package com.example.demo.spring.business.product;

import com.example.demo.spring.business.product.dto.ProductRes;
import com.example.demo.spring.domain.product.entity.Product;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    public List<ProductRes> mapProductToProductRes(List<Product> products) {
        return products.stream()
                .map(ProductRes::from)
                .collect(Collectors.toList());
    }
}
