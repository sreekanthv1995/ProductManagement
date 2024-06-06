package com.product_management.Management.controller;

import com.product_management.Management.dto.MerchantDto;
import com.product_management.Management.service.merchant.MerchantService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {

    private final MerchantService merchantService;

    @PostMapping("/register/merchant")
    public ResponseEntity<?> createMerchant(@RequestBody MerchantDto merchantDto){
        try {
            merchantService.createNewMerchant(merchantDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (EntityExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
