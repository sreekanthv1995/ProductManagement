package com.product_management.Management.service.authService;

import com.product_management.Management.dto.LoginDto;
import com.product_management.Management.entity.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(LoginDto loginDto);
}
