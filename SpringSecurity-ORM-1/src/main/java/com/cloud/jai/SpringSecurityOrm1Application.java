package com.cloud.jai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityOrm1Application {
	private static final Logger logger = LoggerFactory.getLogger(SpringSecurityOrm1Application.class);

	public static void main(String[] args) {
		
		
		logger.info("Main Method started");
		SpringApplication.run(SpringSecurityOrm1Application.class, args);
		
	}

}
