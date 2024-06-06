package com.product_management.Management.service.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {

    String extractUserName (String token);
    <T> T extractClaims(String token, Function<Claims,T> resolver);
    boolean isValid(String token, UserDetails user);
    String generateToken(String email);
    boolean isTokenExpired(String token);

}
