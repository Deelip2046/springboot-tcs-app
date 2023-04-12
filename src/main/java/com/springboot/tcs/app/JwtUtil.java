package com.springboot.tcs.app;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {
	@Value("${jwt.secret}")
	private String secretKey;
	
	@Value("${jwt.expiration}")
	private long expirationTime;
	
	
	public String generateToken(User user) {
		Claims claims = Jwts.claims().setSubject(user.getEmail());
		claims.put("id", user.getId());
		claims.put("firstName", user.getFirstName());
		claims.put("lastName", user.getLastName());
		
		Date now = new Date(expirationTime);
		Date expirayDate = new Date(now.getTime()+ expirationTime);
		
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(expirayDate)
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
		
	}
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		}catch (Exception ex) {
			return false;
		}
	}
	public Claims getClaimsFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
	}

}
