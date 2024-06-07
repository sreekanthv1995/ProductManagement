package com.product_management.Management.repository;

import com.product_management.Management.entity.Merchant;
import com.product_management.Management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByProductName(String productName);
    List<Product> findByMerchantId(UUID merchantId);
}
