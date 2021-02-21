package com.abhi.poc.demo.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Custom error response pojo
 * 
 * @author agalipally
 *
 */
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private Integer code;
    private String message;
    private String type;
    private List<Violation> violations;
    
    public ErrorResponse() {}
    
	public ErrorResponse(Integer code, String message, String type) {
		super();
		this.code = code;
		this.message = message;
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Violation> getViolations() {
		return violations;
	}

	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}
}