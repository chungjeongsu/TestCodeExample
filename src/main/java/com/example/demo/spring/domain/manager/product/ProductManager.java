package com.example.demo.spring.domain.manager.product;

import com.example.demo.spring.infrastructure.jpa.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductManager {
    private final ProductRepository productRepository;


}
