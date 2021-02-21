package com.abhi.poc.demo.models;

/**
 * courier code enum
 * 
 * @author agalipally
 *
 */
public enum Couriercode {
	FedEx("fedex"), UPS("ups"), USPS("usps");

	private String code;

	private Couriercode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public static Couriercode valueOfCode(String code) {
		for (Couriercode e : values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
}