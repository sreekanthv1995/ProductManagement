package com.product_management.Management.service.admin;

import com.product_management.Management.dto.MerchantDto;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.entity.Role;
import com.product_management.Management.repository.MerchantRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService {

    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createNewMerchant(MerchantDto merchantDto) {

        Optional<Merchant> optionalMerchant = merchantRepository.findByEmail(merchantDto.getEmail());
        if (optionalMerchant.isPresent()){
            throw new EntityExistsException();
        }else {
            merchantRepository.save(Merchant.builder()
                    .email(merchantDto.getEmail())
                    .ownerName(merchantDto.getOwnerName())
                    .shopName(merchantDto.getShopName())
                    .password(passwordEncoder.encode(merchantDto.getPassword()))
                    .category(merchantDto.getCategory())
                    .phoneNumber(merchantDto.getPhoneNumber())
                    .active(true)
                    .role(Role.MERCHANT)
                    .build());
        }
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.findAll();
    }
}
