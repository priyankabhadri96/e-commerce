package com.example.e_commerce.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final String secretKey =
            "my-super-secret-key-that-is-long-enough-for-hs256";


    public String generateToken(String username, String role){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15) )
                .signWith(getSigningKey())
                .claim("role",role)
                .compact();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8)
        );
    }
    public Boolean isTokenValid(String token){
        try{
            extractClaims(token);
            return true;
        }
        catch(Exception e) {
            return false;
        }

    }
    public String getUsername(String token){
        return extractClaims(token).getSubject();
    }
    public String getRole(String token){
        return extractClaims(token).get("role",String.class);
    }

    public Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }
}
