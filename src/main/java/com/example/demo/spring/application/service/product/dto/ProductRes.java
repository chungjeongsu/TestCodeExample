package com.example.demo.spring.application.service.product.dto;

import com.example.demo.spring.domain.entity.product.ProductSellingType;
import com.example.demo.spring.domain.entity.product.ProductType;
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
    private ProductSellingType sellingType;
    private String name;
    private int price;

    public static ProductRes from(){

    }
}
