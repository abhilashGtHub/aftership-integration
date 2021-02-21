package com.abhi.poc.demo.models;

/**
 * response pojo class
 * 
 * @author agalipally
 *
 */
public class Response {
	public Meta meta;
	public Object data;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}