package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SrpingJwtApplication {

	public static void main(String[] args) {
		
		log.info("main method Started");
//		System.out.print("main method Started");
		SpringApplication.run(SrpingJwtApplication.class, args);
	}

}
