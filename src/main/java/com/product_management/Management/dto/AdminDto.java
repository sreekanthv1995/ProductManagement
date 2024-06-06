package com.product_management.Management.dto;

import com.product_management.Management.entity.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {

    private String email;
    private Role role;
}
