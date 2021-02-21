package com.abhi.poc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * entry point of the after ship demo application
 * 
 * @author agalipally
 *
 */
@SpringBootApplication
public class AfterShipAssignmentApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AfterShipAssignmentApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AfterShipAssignmentApplication.class);
	}

}
