package com.cloud.jai.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;


@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig {
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	
	DaoAuthenticationProvider AuthenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setPasswordEncoder(bCryptPasswordEncoder);
		auth.setUserDetailsService(userDetailsService);
		
		return auth;
		
	}

	@Bean
	SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
	    return http.authorizeHttpRequests(Request -> Request
	    		.requestMatchers("/admin").hasAuthority("ADMIN") //Admin path
	    		.requestMatchers("/customer").hasAuthority("CUSTOMER") //Customer Path
	            .requestMatchers("/Home", "/").permitAll()  // Public paths
	            .requestMatchers("/user/**").permitAll()
	            .requestMatchers("/Hello").authenticated()  // Requires authentication
	            .anyRequest().permitAll() // Ensures other Endpoints require authentication
	        )
	        .formLogin(login -> login.loginPage("/login")
	            .permitAll() // Enables form-based authentication
	        )
	        .logout(logout -> logout
	            .permitAll() // Allows logout without authentication
	        )
	        .build();
	}

	
	
	
	

	
	
	
}