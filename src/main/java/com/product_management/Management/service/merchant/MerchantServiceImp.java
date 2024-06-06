package com.product_management.Management.service.merchant;

import com.product_management.Management.dto.MerchantDto;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.entity.Role;
import com.product_management.Management.repository.MerchantRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantServiceImp implements MerchantService{

    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void createNewMerchant(MerchantDto merchantDto) {
//        if (!merchantRepository.existByEmail(merchantDto.getEmail())){
            merchantRepository.save(Merchant.builder()
                    .email(merchantDto.getEmail())
                    .ownerName(merchantDto.getOwnerName())
                    .password(passwordEncoder.encode(merchantDto.getPassword()))
                    .category(merchantDto.getCategory())
                    .role(Role.MERCHANT)
                    .build());
//        }else{
//            throw new EntityExistsException();
//        }
    }
}
