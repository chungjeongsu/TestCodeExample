package com.example.demo.spring.presentation.product;

import com.example.demo.spring.business.product.ProductService;
import com.example.demo.spring.business.product.dto.ProductRes;
import com.example.demo.spring.global.response.CommonRes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * 판매중인 상품 리스트를 가져오는 API
     */
    @GetMapping("/api/v1/products/selling")
    public CommonRes<List<ProductRes>> readSellingProducts() {
        return CommonRes.success(productService.readSellingProducts());
    }
}
