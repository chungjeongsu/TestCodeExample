package com.example.demo.spring.application.service.product;

import com.example.demo.spring.application.service.product.dto.ProductRes;

import java.util.List;

public interface ProductUseCase {
    List<ProductRes> getSellingProducts();
}
