package com.cloud.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityMvcJdbcApplication {

	public static void main(String[] args) {
		System.out.println("Main :: Method");
		SpringApplication.run(SpringSecurityMvcJdbcApplication.class, args);
	}

}
