package com.product_management.Management.service.authService;

import com.product_management.Management.entity.Admin;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.repository.AdminRepository;
import com.product_management.Management.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class customUserDetailsService implements UserDetailsService {

    private final MerchantRepository merchantRepository;
    private final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Admin> admin = adminRepository.findByEmail(email);
        if (admin.isPresent()){
            return admin.get();
        }
        Optional<Merchant> merchant = merchantRepository.findByEmail(email);
        if (merchant.isPresent()){
            return merchant.get();
        }
        throw new UsernameNotFoundException("Email not sound "+ email);
    }
}
