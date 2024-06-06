package com.product_management.Management.entity;

import com.product_management.Management.dto.AdminDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AuthResponse {

//    private Merchant merchant;
    private String email;
    private Role role;
    private String token;

}
