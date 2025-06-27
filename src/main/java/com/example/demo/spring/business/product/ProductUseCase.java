package com.example.demo.spring.business.product;

import com.example.demo.spring.business.product.dto.ProductRes;

import java.util.List;

public interface ProductUseCase {
    List<ProductRes> readSellingProducts();
}
