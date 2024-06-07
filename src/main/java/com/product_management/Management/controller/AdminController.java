package com.product_management.Management.controller;

import com.product_management.Management.dto.MerchantDto;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.service.admin.AdminService;
import com.product_management.Management.service.merchant.MerchantService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/register/merchant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createMerchant(@RequestBody MerchantDto merchantDto){
        try {
            adminService.createNewMerchant(merchantDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (EntityExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Merchant with this email already exists");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating merchant");
        }
    }

    @GetMapping("/get/merchants")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Merchant>> listAllMerchant(){
        return ResponseEntity.ok(adminService.getAllMerchant());
    }

    @DeleteMapping("/delete/merchant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?>deleteMerchant(@RequestParam UUID merchantId){
        return ResponseEntity.ok(adminService.deleteMerchant(merchantId));
    }
}
