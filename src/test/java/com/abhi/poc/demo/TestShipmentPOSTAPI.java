package com.abhi.poc.demo;


import java.util.Random;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class TestShipmentPOSTAPI {
	
	public static final String ROOT_URI = "http://localhost:8080/afterShip/api";
	public static final String AFTER_SHIP_VALID_API_KEY_VALUE = "c603e0db-8072-4766-83bf-cc2166a93d1f";
	public static final String AFTER_SHIP_INVALID_API_KEY_VALUE = "123456789";
	public static final String AFTER_SHIP_API_KEY_NAME= "aftership-api-key";
	public static final String AFTER_SHIP_VALID_TRACKINGNUMBER = "FJIEQWFHEIJFHIEWHF1";
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	final void testCreateShipmentAPIKeyMissing() {
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"   \"origin\": \"AFG\",\r\n" + 
						"   \"destination\": \"AGO\",\r\n" + 
						"   \"trackingNumber\": \"KAFJ7934253OPASD363423794714IFASDH1234528011123\",\r\n" + 
						"   \"courierCode\": \"FedEx\"\r\n" + 
						"}")
				.when()
				.post(ROOT_URI + "/shipments");
		response.then().body("status", Matchers.comparesEqualTo(400));
		response.then().body("message", Matchers.comparesEqualTo("Missing request header 'aftership-api-key' for method parameter of type String"));
		
		
	}
	
	@Test
	final void testCreateShipmentInvalidAPIKeyMissing() {
		Header invalidHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_INVALID_API_KEY_VALUE);
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"   \"origin\": \"AFG\",\r\n" + 
						"   \"destination\": \"AGO\",\r\n" + 
						"   \"trackingNumber\": \"KAFJ7934253OPASD363423794714IFASDH1234528011123\",\r\n" + 
						"   \"courierCode\": \"FedEx\"\r\n" + 
						"}")
				.when()
				.header(invalidHeader)
				.post(ROOT_URI + "/shipments");
		response.then().body("code", Matchers.comparesEqualTo(401));
		response.then().body("message", Matchers.comparesEqualTo("401 Unauthorized"));
		
		
	}
	
	@Test
	final void testCreateShipmentEmptyPayload() {
		Header invalidHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_INVALID_API_KEY_VALUE);
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.header(invalidHeader)
				.post(ROOT_URI + "/shipments");
		response.then().body("status", Matchers.comparesEqualTo(400));
		response.then().body("message", Matchers.containsString("Required request body is missing:"));
		
		
	}
	
	
	@Test
	final void testCreateShipmentMissingManadatoryFields() {
		Header invalidHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_INVALID_API_KEY_VALUE);
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{}")
				.when()
				.header(invalidHeader)
				.post(ROOT_URI + "/shipments");
		response.then().body("code", Matchers.comparesEqualTo(400));
		response.then().body("message", Matchers.comparesEqualTo("Mandatory fields are Missing."));
		
		
	}
	
	@Test
	final void testCreateShipmentDuplicateTrackingNumber() {
		Header validHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_VALID_API_KEY_VALUE);
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"   \"origin\": \"AFG\",\r\n" + 
						"   \"destination\": \"AGO\",\r\n" + 
						"   \"trackingNumber\": \"FJIEQWFHEIJFHIEWHF1\",\r\n" + 
						"   \"courierCode\": \"FedEx\"\r\n" + 
						"}")
				.when()
				.header(validHeader)
				.post(ROOT_URI + "/shipments");
		response.then().body("code", Matchers.comparesEqualTo(400));
		response.then().body("message", Matchers.comparesEqualTo("Tracking already exists."));
		
		
	}
	
	@Test
	final void testCreateShipmentInvalidCourierCode() {
		Header validHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_VALID_API_KEY_VALUE);
		
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"   \"origin\": \"AFG\",\r\n" + 
						"   \"destination\": \"AGO\",\r\n" + 
						"   \"trackingNumber\": \"FJIEQWFHEIJFHIEWHF1\",\r\n" + 
						"   \"courierCode\": \"4342\"\r\n" + 
						"}")
				.when()
				.header(validHeader)
				.post(ROOT_URI + "/shipments");
		response.then().body("status", Matchers.comparesEqualTo(400));
		response.then().body("message", Matchers.containsString("not one of the values accepted for Enum class: [FedEx, USPS, UPS];"));
		
		
	}
	
	@Test
	final void testCreateShipment() {
		Header validHeader = new Header(AFTER_SHIP_API_KEY_NAME, AFTER_SHIP_VALID_API_KEY_VALUE);
		Random random = new Random();
		int trackingNumber = random.nextInt();
		Response response = RestAssured.given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"   \"origin\": \"AFG\",\r\n" + 
						"   \"destination\": \"AGO\",\r\n" + 
						"   \"trackingNumber\": " + trackingNumber +",\r\n" + 
						"   \"courierCode\": \"FedEx\"\r\n" + 
						"}")
				.when()
				.header(validHeader)
				.post(ROOT_URI + "/shipments");
		response.then().body("courierCode", Matchers.comparesEqualTo("FedEx"));
		response.then().body("trackingNumber", Matchers.containsString(String.valueOf(trackingNumber)));
		
		
	}

}
