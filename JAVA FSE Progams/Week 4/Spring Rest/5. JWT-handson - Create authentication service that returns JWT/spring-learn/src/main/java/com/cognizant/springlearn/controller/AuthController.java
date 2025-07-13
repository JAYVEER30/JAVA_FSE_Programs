package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> generateToken(@RequestHeader("Authorization") String authHeader) {
        try {
            // Decode Basic Auth Header
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] credDecoded = java.util.Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded);
            final String[] values = credentials.split(":", 2);

            // Authenticate user
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(values[0], values[1])
            );

            // Generate token
            String token = jwtUtil.generateToken(values[0]);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;

        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid Credentials");
        }
    }
}
