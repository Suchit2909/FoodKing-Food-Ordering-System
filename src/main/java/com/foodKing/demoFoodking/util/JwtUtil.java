package com.foodKing.demoFoodking.util;



import java.security.Key;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String SECRET_KEY;
	
	 @Value("${jwt.expiration}")
	    private long JWT_EXPIRATION;
	 
	 private Key getSigningKey() {
		 
		 byte[] KeyBytes = Base64.getDecoder().decode(SECRET_KEY);
		 return new SecretKeySpec(KeyBytes, SignatureAlgorithm.HS256.getJcaName());
	 }
	 
	 
	 public String generateToken(String username, String role) {
		 return Jwts.builder()
				 .setSubject(username)
				 .claim("role", role)
				 .setIssuedAt(new Date())
				 .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
				 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
				 .compact();
		 
	 }
	 
	 public String extractUsername(String token) {
	        return extractAllClaims(token).getSubject();
	    }

	    // ✅ Extract role from token
	    public String extractRole(String token) {
	        return extractAllClaims(token).get("role", String.class);
	    }

	    // ✅ Check if token is expired
	    public boolean isTokenExpired(String token) {
	        return extractAllClaims(token).getExpiration().before(new Date());
	    }

	    // ✅ Common method to extract all claims
	    private Claims extractAllClaims(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(getSigningKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
}
