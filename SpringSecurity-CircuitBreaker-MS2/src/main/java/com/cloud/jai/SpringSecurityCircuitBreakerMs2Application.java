package com.cloud.jai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityCircuitBreakerMs2Application {

	
	
	public static void main(String[] args) {
		Logger logger =  LoggerFactory.getLogger(SpringSecurityCircuitBreakerMs2Application.class);
		logger.info("Main Method Started");
		
		SpringApplication.run(SpringSecurityCircuitBreakerMs2Application.class, args);
	}

}
