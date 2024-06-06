package com.product_management.Management.service.userService;

import com.product_management.Management.entity.Admin;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.repository.AdminRepository;
import com.product_management.Management.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final MerchantRepository merchantRepository;
    private final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByEmail(email);
        if (admin != null){
            return admin;
        }
        Merchant merchant = merchantRepository.findByEmail(email);
        if (merchant != null){
            return merchant;
        }

        throw new UsernameNotFoundException("Email not sound "+ email);
    }
}
