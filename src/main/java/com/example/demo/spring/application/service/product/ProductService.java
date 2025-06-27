package com.example.demo.spring.application.service.product;

import com.example.demo.spring.application.service.product.dto.ProductRes;
import com.example.demo.spring.domain.manager.product.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase{
    private final ProductManager productManager;

    @Override
    public List<ProductRes> getSellingProducts() {

    }
}
