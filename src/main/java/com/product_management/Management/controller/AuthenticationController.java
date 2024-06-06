package com.product_management.Management.controller;

import com.product_management.Management.dto.LoginDto;
import com.product_management.Management.entity.AuthResponse;
import com.product_management.Management.service.authService.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(authService.authenticate(loginDto));
    }




}
