package com.abhi.poc.demo.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.abhi.poc.demo.models.Response;
import com.google.gson.Gson;

/**
 * global exception handler for all application level exceptions
 * 
 * @author agalipally
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private Environment environment;
	private Gson gson = new Gson();

	public GlobalExceptionHandler(final Environment environment) {
		this.environment = environment;
	}
	
	/**
	 * handles HttpClientErrorException exception
	 * 
	 * @param response
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleApiException(HttpServletResponse response, HttpClientErrorException ex) {
		log.error("handleApiException - exception : {}", ExceptionUtils.getStackTrace(ex)); 
		Response responseBody = gson.fromJson(ex.getResponseBodyAsString(), Response.class);
		
		String message = responseBody != null ? (responseBody.getMeta() != null ? responseBody.getMeta().getMessage() : "") : ex.getMessage();
		String type = responseBody != null ? (responseBody.getMeta() != null ? responseBody.getMeta().getType() : "") : ex.getStatusText();
		ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode().value(), message, type);
		return new ResponseEntity<ErrorResponse>(errorResponse, ex.getStatusCode());
	}
	
	/**
	 * handles ConstraintViolationException
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ErrorResponse onConstraintValidationException(ConstraintViolationException e) {
		log.error("onConstraintValidationException - exception : {}", ExceptionUtils.getStackTrace(e));
		ErrorResponse error = new ErrorResponse();
		List<Violation> violations = new ArrayList<>();
		error.setViolations(violations);
		
		for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
			error.getViolations()
					.add(new Violation(violation.getPropertyPath().toString(), getMessage(violation.getMessage())));
		}
		error.setCode(400);
		error.setMessage("Mandatory fields are Missing.");
		return error;
	}

	/**
	 * handles MethodArgumentNotValidException
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.error("onMethodArgumentNotValidException - exception : {}", ExceptionUtils.getStackTrace(e));
		ErrorResponse error = new ErrorResponse();
		List<Violation> violations = new ArrayList<>();
		error.setViolations(violations);
		
		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new Violation(fieldError.getField(), getMessage(fieldError.getDefaultMessage())));
		}
		error.setCode(400);
		error.setMessage("Mandatory fields are Missing.");
		return error;
	}
	
	/**
	 * returns the message from the exception
	 * 
	 * @param key
	 * @return
	 */
	private String getMessage(final String key) {
		String message = key;
		try {
			String envMessage = environment.getProperty(key);
			if (null != envMessage && !envMessage.isEmpty()) {
				message = envMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}
