package com.example.demo.spring.domain.product;

import com.example.demo.spring.domain.product.entity.Product;
import com.example.demo.spring.domain.product.entity.ProductSellingStatus;
import com.example.demo.spring.infra.jpa.product.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductManager {
    private final ProductRepository productRepository;

    public List<Product> findAllBySellingStatus() {
        return productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());
    }
}
