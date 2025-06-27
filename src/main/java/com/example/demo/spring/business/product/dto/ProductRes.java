package com.example.demo.spring.business.product.dto;

import com.example.demo.spring.domain.product.entity.Product;
import com.example.demo.spring.domain.product.entity.ProductSellingStatus;
import com.example.demo.spring.domain.product.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductRes {
    private Long id;
    private String productNumber;
    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

    public static ProductRes from(Product product){
        return ProductRes.builder()
                .id(product.getId())
                .productNumber(product.getProductNumber())
                .type(product.getType())
                .sellingStatus(product.getSellingStatus())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
