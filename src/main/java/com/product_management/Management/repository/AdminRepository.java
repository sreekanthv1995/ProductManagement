package com.product_management.Management.repository;

import com.product_management.Management.entity.Admin;
import com.product_management.Management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByEmail(String email);
    Admin findByRole(Role role);
}
