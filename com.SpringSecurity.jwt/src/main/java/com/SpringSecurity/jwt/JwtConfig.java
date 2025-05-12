package com.SpringSecurity.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtConfig {
    String secreteKey = "jai_sharma_super_secret_key_123456";
            public void createToken(){

                // creating token
                String token = Jwts.builder()
                        .setId("id23")
                        .setSubject("Security")
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2)))
                        .setIssuer("pwskill")
                        .signWith(SignatureAlgorithm.HS256, secreteKey.getBytes()) // Use HS256 for string keys
                        .compact();

                // retrieving token details
                Claims claims = Jwts.parser()
                        .setSigningKey(secreteKey.getBytes())
                        .parseClaimsJws(token)
                        .getBody();

                System.out.println(claims.getSubject());
                System.out.println(claims.getIssuer());
                System.out.println(claims.getExpiration());



            }






        }






