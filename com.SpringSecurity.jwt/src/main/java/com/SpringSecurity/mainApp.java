package com.SpringSecurity;

import com.SpringSecurity.jwt.JwtConfig;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class mainApp {



    public static void main(String[] args) {
        log.info("Starting Spring Boot application...");
        SpringApplication.run(mainApp.class, args);
        JwtConfig jc = new JwtConfig();
        jc.createToken();





    }
}