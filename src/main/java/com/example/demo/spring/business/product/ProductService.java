package com.example.demo.spring.business.product;

import com.example.demo.spring.business.product.dto.ProductRes;
import com.example.demo.spring.domain.product.ProductManager;
import com.example.demo.spring.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase{
    private final ProductManager productManager;
    private final ProductMapper mapper;

    /**
     * 판매중인 상품 리스트를 가져오는 API
     * 1. 상품 리스트를 가져온다.
     * 2. ProductRes로 매핑 후 return 한다.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductRes> readSellingProducts() {
        List<Product> products = productManager.findAllBySellingStatus();
        return mapper.mapProductToProductRes(products);
    }
}
