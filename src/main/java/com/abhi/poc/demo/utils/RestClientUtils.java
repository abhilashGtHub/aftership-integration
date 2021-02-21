package com.abhi.poc.demo.utils;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.abhi.poc.demo.ApplicationConfig;
import com.abhi.poc.demo.models.Response;
import com.abhi.poc.demo.models.TrackingPayload;

/**
 * util class to handle all the REST API calls
 * 
 * @author agalipally
 *
 */
@Component
public class RestClientUtils {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ApplicationConfig appConfig;
	
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		log.info("init started to create rest template...");
		restTemplate = new RestTemplate();
	}
	
	/**
	 * builds the request header
	 * 
	 * @param apiKey
	 * @return
	 */
	private HttpHeaders buildHeaders(String apiKey) {
		log.info("buildHeaders started");
		HttpHeaders headers = new HttpHeaders();
		headers.set("aftership-api-key", apiKey);
		log.info("buildHeaders added after ship api key header ");
		return headers;
	}
	
	/**
	 * after ship API post call
	 * 
	 * @param apiKey
	 * @param tracking
	 * @return
	 */
	public Response postTracking(String apiKey, TrackingPayload tracking) {
		log.info("postTracking started >> trackingPayload: {}", tracking);
		HttpEntity<TrackingPayload> request = new HttpEntity<>(tracking, buildHeaders(apiKey));
		log.info("postTracking prepared request to make rest call");
		return restTemplate.exchange(appConfig.getAftershipApiTrackingUrl(), HttpMethod.POST, request, Response.class).getBody();
	}
	
	/**
	 * after ship API get call
	 * 
	 * @param apiKey
	 * @param slug
	 * @param trackingNumber
	 * @return
	 */
	public Response getTracking(String apiKey, String slug, String trackingNumber) {
		log.info("getTracking started >> slug: {}, trackingNumber: {}", slug, trackingNumber);
		HttpEntity<String> request = new HttpEntity<>(buildHeaders(apiKey));
		String url = String.format(appConfig.getAftershipApiGetTrackingUrl(), slug, trackingNumber);
		log.info("getTracking prepared request getUrl:{}", url);
		return restTemplate.exchange(url, HttpMethod.GET, request, Response.class).getBody();
	}
	
}
