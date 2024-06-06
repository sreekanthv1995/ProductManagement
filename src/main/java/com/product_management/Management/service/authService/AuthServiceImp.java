package com.product_management.Management.service.authService;

import com.product_management.Management.dto.LoginDto;
import com.product_management.Management.entity.Admin;
import com.product_management.Management.entity.AuthResponse;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.repository.AdminRepository;
import com.product_management.Management.repository.MerchantRepository;
import com.product_management.Management.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService{

    private final AdminRepository adminRepository;
    private final MerchantRepository merchantRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse authenticate(LoginDto loginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()));
            Optional<Admin> admin = adminRepository.findByEmail(loginDto.getEmail());
            Optional<Merchant> merchant = merchantRepository.findByEmail(loginDto.getEmail());
            if (admin.isPresent()) {
                String token = jwtService.generateToken(admin.get().getEmail());
                return AuthResponse.builder()
                        .email(admin.get().getEmail())
                        .role(admin.get().getRole())
                        .token(token)
                        .build();
            }
            if (merchant.isPresent()) {
                String token = jwtService.generateToken(merchant.get().getEmail());
                return AuthResponse.builder()
                        .email(merchant.get().getEmail())
                        .role(merchant.get().getRole())
                        .token(token)
                        .build();
            }
            throw new BadCredentialsException("Invalid Credentials");
        }catch (BadCredentialsException e){
            throw new RuntimeException("invalid email or password");
        }
    }
}
