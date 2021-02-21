package com.abhi.poc.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * application configuration class
 * 
 * @author agalipally
 *
 */
@Component
public class ApplicationConfig {
	@Value("${aftership.api.tracking.url}")
	private String aftershipApiTrackingUrl;
	
	@Value("${aftership.api.get.tracking.url}")
	private String aftershipApiGetTrackingUrl; 
	
	public String getAftershipApiGetTrackingUrl() {
		return aftershipApiGetTrackingUrl;
	}

	public String getAftershipApiTrackingUrl() {
		return aftershipApiTrackingUrl;
	}
	
}
