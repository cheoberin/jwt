package com.codewithprojects.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    public String extractUsername(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
