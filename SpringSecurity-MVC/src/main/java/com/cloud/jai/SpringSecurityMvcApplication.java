package com.cloud.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityMvcApplication {

	public static void main(String[] args) {
		System.out.println("Main Engine Started");
		SpringApplication.run(SpringSecurityMvcApplication.class, args);
	}

}
