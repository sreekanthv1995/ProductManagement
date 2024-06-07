package com.product_management.Management.controller;

import com.product_management.Management.dto.ProductDto;
import com.product_management.Management.entity.Product;
import com.product_management.Management.service.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/add/product")
    @PreAuthorize("hasRole('MERCHANT')")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto,
                                              @RequestParam String email){
        return ResponseEntity.ok(merchantService.addProduct(productDto,email));
    }

    @GetMapping("/get/products")
    public ResponseEntity<List<Product>> listAllProductByMerchant(@RequestParam UUID merchantId) {
        return ResponseEntity.ok(merchantService.getAllProducts(merchantId));
    }
}
