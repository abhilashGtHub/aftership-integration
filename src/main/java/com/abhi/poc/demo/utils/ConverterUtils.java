package com.abhi.poc.demo.utils;

import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.abhi.poc.demo.models.Couriercode;
import com.abhi.poc.demo.models.Response;
import com.abhi.poc.demo.models.Shipment;
import com.abhi.poc.demo.models.Tracking;
import com.abhi.poc.demo.models.TrackingPayload;

/**
 * utils to hanlde the conversions of after ship tracking & shipment
 * 
 * @author agalipally
 *
 */
@Component
public class ConverterUtils {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * convert trackignResp to a simple tracking object
	 * 
	 * @param trackingResp
	 * @return
	 */
	public Shipment prepareSimpleTracking(Tracking trackingResp) {
		log.info("prepareSimpleTracking started >> ClientTrackingResponse: {}", trackingResp);
		Shipment simpleTracking = new Shipment();

		if (trackingResp != null) {
			log.debug("prepareSimpleTracking inside trackingResp not null");
			simpleTracking.setId(trackingResp.getId());
			simpleTracking.setOrigin(trackingResp.getOriginCountryIso3());
			simpleTracking.setDestination(trackingResp.getDestinationCountryIso3());
			simpleTracking.setCurrentStatus(trackingResp.getTag());
			simpleTracking.setTrackingNumber(trackingResp.getTrackingNumber());
			simpleTracking.setCourierCode(Couriercode.valueOf(trackingResp.getSlug()));
		}
		log.info("prepareSimpleTracking returning simpleTracking: {}",simpleTracking);
		return simpleTracking;
	}

	/**
	 * generates the request paylod for the aftership POST API
	 * 
	 * @param shipment
	 * @return
	 */
	public TrackingPayload prepareTrackingObj(Shipment shipment) {
		log.info("prepareTrackingObj started >> shipment: {}", shipment);
		if(shipment == null) {
			log.debug("prepareTrackingObj inside shipment null");
			return null;
		}
		TrackingPayload newTracking = new TrackingPayload();
		Tracking tracking = new Tracking();
		tracking.setTrackingNumber(shipment.getTrackingNumber());
		tracking.setOrderId(shipment.getId());
		tracking.setOriginCountryIso3(shipment.getOrigin());
		tracking.setDestinationCountryIso3(shipment.getDestination());
		if(shipment.getCourierCode() != null) {
			tracking.setSlug(shipment.getCourierCode().name());
		}
		newTracking.setTracking(tracking);
		log.info("prepareTrackingObj returning trackingPayLoad: {}", newTracking);
		return newTracking;
	}
	
	/**
	 * converts the after ship response to simple shipment
	 * 
	 * @param response
	 * @return
	 */
	public Shipment prepareShipmentFromResponse(Response response) {
		log.info("prepareShipmentFromResponse  started >> response: {}", response);
		if(response == null) {
			log.debug("prepareShipmentFromResponse inside response null");
			return null;
		}
		
		/** TODO::: **/
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> respMap = (LinkedHashMap<String, Object>)response.getData();
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, String> valueMap = (LinkedHashMap<String, String>)respMap.get("tracking");
		
		Shipment shipment = new Shipment();
		shipment.setId(valueMap.get("id"));
		shipment.setOrigin(valueMap.get("origin_country_iso3"));
		shipment.setTrackingNumber(valueMap.get("tracking_number"));
		shipment.setCourierCode(Couriercode.valueOfCode(valueMap.get("slug")));
		shipment.setCurrentStatus(valueMap.get(valueMap.get("tag")));
		shipment.setDestination(valueMap.get("destination_country_iso3"));
		log.info("prepareShipmentFromResponse returning shipment: {}", shipment);
		return shipment;
	}

}
