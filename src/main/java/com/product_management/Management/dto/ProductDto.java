package com.product_management.Management.dto;

import lombok.Data;


@Data
public class ProductDto {
    private String productName;
    private Integer price;
    private Integer stock;
}
