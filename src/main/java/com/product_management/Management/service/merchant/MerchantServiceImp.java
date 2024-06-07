package com.product_management.Management.service.merchant;

import com.product_management.Management.dto.ProductDto;
import com.product_management.Management.entity.Merchant;
import com.product_management.Management.entity.Product;
import com.product_management.Management.repository.MerchantRepository;
import com.product_management.Management.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MerchantServiceImp implements MerchantService{

    private final MerchantRepository merchantRepository;
    private final ProductRepository productRepository;


    @Override
    public boolean addProduct(ProductDto productDto,String email) {
        Optional<Merchant> optionalMerchant = merchantRepository.findByEmail(email);
        Optional<Product> optionalProduct = productRepository.findByProductName(productDto.getProductName());
        if (optionalProduct.isPresent()){
            return false;
        }
        if (optionalMerchant.isPresent()){
            Merchant merchant = optionalMerchant.get();
             productRepository.save(Product
                    .builder()
                            .productName(productDto.getProductName())
                            .price(productDto.getPrice())
                            .active(true)
                            .stock(productDto.getStock())
                            .merchant(merchant)
                    .build());
             return true;
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<Product> getAllProducts(UUID merchantId) {
//        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(()->new EntityNotFoundException("Not found"));
        return productRepository.findByMerchantId(merchantId);
    }
}
