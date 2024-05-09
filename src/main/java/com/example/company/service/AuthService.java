package com.example.company.service;

import com.example.company.config.JwtService;
import com.example.company.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();

        if (!isUserAuthenticated(loginRequest)) {
            // TODO ADD CUSTOM EXCEPTION
        }

        return jwtService.generateToken(username);
    }

    private boolean isUserAuthenticated(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = String.valueOf(loginRequest.getPassword());

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        ).isAuthenticated();
    }

}
