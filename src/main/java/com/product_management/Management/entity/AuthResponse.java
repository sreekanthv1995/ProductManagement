package com.product_management.Management.entity;

import com.product_management.Management.dto.AdminDto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AuthResponse {

    private String email;
    private Role role;
    private String token;

}
