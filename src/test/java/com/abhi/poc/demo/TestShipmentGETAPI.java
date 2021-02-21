package com.abhi.poc.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class TestShipmentGETAPI {
	
	public static final String ROOT_URI = "http://localhost:8080/afterShip/api";
	public static final String AFTER_SHIP_VALID_API_KEY_VALUE = "c603e0db-8072-4766-83bf-cc2166a93d1f";
	public static final String AFTER_SHIP_INVALID_API_KEY_VALUE = "123456789";
	public static final String AFTER_SHIP_API_KEY_NAME= "aftership-api-key";
	public static final String AFTER_SHIP_VALID_TRACKINGNUMBER = "FJIEQWFHEIJFHIEWHF1";
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	final void testGetShipmentAPIKeyMissing() {
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				
				.when()
				.get(ROOT_URI + "/shipments/fedex/"+AFTER_SHIP_VALID_TRACKINGNUMBER);
		response.then().body("status", Matchers.comparesEqualTo(400));
		response.then().body("message", Matchers.comparesEqualTo("Missing request header 'aftership-api-key' for method parameter of type String"));
		
		
	}
	
	@Test
	final void testGetShipmentInvalidAPIKey() {
		Header invalidHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_INVALID_API_KEY_VALUE);
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.header(invalidHeader)
				.get(ROOT_URI + "/shipments/fedex/"+AFTER_SHIP_VALID_TRACKINGNUMBER);
		response.then().body("code", Matchers.comparesEqualTo(401));
		response.then().body("message", Matchers.comparesEqualTo("Invalid API key."));
		
		
	}
	
	
	
	@Test
	final void testGETShipmentForInvalidTrackingNumber() {
		Header validHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_VALID_API_KEY_VALUE);
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.header(validHeader)
				.get(ROOT_URI + "/shipments/FedEx/"+"dfjoash");
		response.then().body("code", Matchers.comparesEqualTo(404));
		response.then().body("message", Matchers.comparesEqualTo("Tracking does not exist."));
		
		
	}
	
	
	
	@Test
	final void testGetShipment() {
		Header validHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_VALID_API_KEY_VALUE);
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.when()
				.header(validHeader)
				.get(ROOT_URI + "/shipments/FedEx/"+AFTER_SHIP_VALID_TRACKINGNUMBER);
		response.then().body("courierCode", Matchers.comparesEqualTo("FedEx"));
		response.then().body("trackingNumber", Matchers.containsString(AFTER_SHIP_VALID_TRACKINGNUMBER));
		
		
	}


}
