package com.abhi.poc.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.poc.demo.models.Shipment;
import com.abhi.poc.demo.service.ShipmentService;

/**
 * rest controller for all shipment APIs
 * 
 * @author agalipally
 *
 */
@RestController
@RequestMapping(value="/shipments")

public class ShipmentController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ShipmentService trackingService;
	
	/**
	 * create shipment
	 * 
	 * @param shipment
	 * @param apiKey
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public Shipment createShipment(
			@Validated @RequestBody Shipment shipment,
			@RequestHeader("aftership-api-key") String apiKey) throws Exception {
		log.info("createTracking() started for the shipment : {}", shipment);
		return this.trackingService.createShipment(shipment, apiKey);
		
	}
	
	/**
	 * get shipment by id
	 * 
	 * @param slug
	 * @param trackingNumber
	 * @param apiKey
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{slug}/{tracking_number}")
	public Shipment getShipmentsByTrackingNumber(
			final @PathVariable("slug") String slug,
			final @PathVariable("tracking_number") String trackingNumber,
			@RequestHeader("aftership-api-key") String apiKey) throws Exception {
		log.info("getShipmentByTrackingNumber stated with params slug: {}, trackingNumber: {}",slug,trackingNumber);
		return this.trackingService.getTrackingById(apiKey, slug, trackingNumber);
	}

}
