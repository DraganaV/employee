package com.example.company.service;

import com.example.company.config.JwtService;
import com.example.company.dto.LoginRequest;
import com.example.company.exceptions.DataNotFoundException;
import com.example.company.model.UserEntity;
import com.example.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public String login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();

        authenticate(loginRequest)
                .orElseThrow(()->new DataNotFoundException("User not found with username = " + username));;

        return jwtService.generateToken(username);
    }

    private Optional<UserEntity> authenticate(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        loginRequest.getPassword()
                )
        );

        return userRepository.findUserByUsername(username);
    }

}
