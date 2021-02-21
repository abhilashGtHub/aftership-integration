package com.abhi.poc.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.poc.demo.ApplicationConfig;
import com.abhi.poc.demo.models.Response;
import com.abhi.poc.demo.models.Shipment;
import com.abhi.poc.demo.utils.ConverterUtils;
import com.abhi.poc.demo.utils.RestClientUtils;

/**
 * service for handling shipment relatated operations
 * 
 * @author agalipally
 *
 */
@Service
public class ShipmentService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ConverterUtils converter;

	@Autowired
	RestClientUtils restClientUtils;

	@Autowired
	ApplicationConfig appConfig;

	/**
	 * creates shipment
	 * 
	 * @param shipment
	 * @param apiKey
	 * @return
	 */
	public Shipment createShipment(Shipment shipment, String apiKey) {
		log.info("createShipment started with params shipmentRequest: {}",shipment);
		Response clientResponse = restClientUtils.postTracking(apiKey, converter.prepareTrackingObj(shipment));
		return converter.prepareShipmentFromResponse(clientResponse);
	}
	
	/**
	 * gets shipment by id
	 * 
	 * @param apiKey
	 * @param slug
	 * @param trackingNumber
	 * @return
	 */
	public Shipment getTrackingById(String apiKey, String slug, String trackingNumber) {
		log.info("getTrackingById started with params slig: {}, trackingNumber: {}", slug, trackingNumber);
		Response clientResponse = restClientUtils.getTracking(apiKey, slug, trackingNumber);
		return converter.prepareShipmentFromResponse(clientResponse);
	}
}
