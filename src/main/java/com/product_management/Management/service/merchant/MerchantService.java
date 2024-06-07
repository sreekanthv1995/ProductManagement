package com.product_management.Management.service.merchant;

import com.product_management.Management.dto.ProductDto;
import com.product_management.Management.entity.Product;

import java.util.List;
import java.util.UUID;

public interface MerchantService {


    boolean addProduct(ProductDto productDto, String email);

    List<Product> getAllProducts(UUID merchantId);

    boolean deleteProduct(Long id);
}
