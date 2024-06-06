package com.product_management.Management.repository;

import com.product_management.Management.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
    Merchant findByEmail(String email);
}
