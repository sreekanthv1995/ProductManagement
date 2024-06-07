package com.product_management.Management.service.admin;

import com.product_management.Management.dto.MerchantDto;
import com.product_management.Management.entity.Merchant;

import java.util.List;

public interface AdminService {
    void createNewMerchant(MerchantDto merchantDto);

    List<Merchant> getAllMerchant();

}
