package com.abhi.poc.demo.models;

import javax.validation.constraints.NotNull;

/**
 * shipment pojo class
 * 
 * @author agalipally
 *
 */
public class Shipment {
	
	private String id;
	
	@NotNull(message="origin is mandatory")
	private String origin;
	
	@NotNull(message="destination is mandatory")
	private String destination;
	
	@NotNull(message="courierCode is mandatory")
	private Couriercode courierCode;
	
	private String currentStatus;
	
	@NotNull(message="trackingNumber is mandatory")
	private String trackingNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Couriercode getCourierCode() {
		return courierCode;
	}

	public void setCourierCode(Couriercode courierCode) {
		this.courierCode = courierCode;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	
}
