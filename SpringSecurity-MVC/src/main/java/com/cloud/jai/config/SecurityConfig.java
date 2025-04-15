package com.cloud.jai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain configurePath(HttpSecurity http) throws Exception {
		
	    return http.authorizeHttpRequests(Request -> Request
	            .requestMatchers("/Home", "/").permitAll()  // Public paths
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

	
	

	
	//2.Authentication
	
	@SuppressWarnings("deprecation")
	@Bean
	 UserDetailsService UDS() {
		System.out.print("SecurityConfig.UDS :: IN Memory Authentication");
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
		    .username("Jai")
		    .password("Sharma")
		    .build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
			    .username("ghost")
			    .password("1234")
			    .build();
		
		InMemoryUserDetailsManager Imudm = new InMemoryUserDetailsManager(user1,user2);
		
		
		return Imudm; 
	}	
}
