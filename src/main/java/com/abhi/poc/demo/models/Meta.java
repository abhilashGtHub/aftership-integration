package com.abhi.poc.demo.models;

/**
 * meta pojo class
 * 
 * @author agalipally
 *
 */
public class Meta {
	private Integer code;
	private String message;
	private String type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}