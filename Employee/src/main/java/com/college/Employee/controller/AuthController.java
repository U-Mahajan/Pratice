package com.college.Employee.controller;

import com.college.Employee.dto.JWTAuthResponse;
import com.college.Employee.dto.LoginDto;
import com.college.Employee.dto.RegisterDto;
import com.college.Employee.servies.AuthService;
import io.jsonwebtoken.Header;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login"})
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        HttpHeaders ee = new HttpHeaders();
        ee.add("token",jwtAuthResponse.getAccessToken());
        return new ResponseEntity("User Login successfully",ee,HttpStatus.OK );
    }

    // Build Register REST API
    @PostMapping(value = {"/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
