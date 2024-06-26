package org.example.amazonback.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.amazonback.dto.user.UserLoginRequestDto;
import org.example.amazonback.dto.user.UserLoginResponseDto;
import org.example.amazonback.service.authentication.AuthenticationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private static final String LOCAL_URL = "http://localhost:5173";

    @CrossOrigin(origins = {LOCAL_URL})
    @PostMapping("/login")
    public UserLoginResponseDto loginUser(@Valid @RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
