package com.example.demo.spring.business.order.dto;

import com.example.demo.spring.business.product.dto.ProductRes;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderCreateRes {
    private Long id;
    private Integer totalPrice;
    private LocalDateTime registeredDateTime;

    private List<ProductRes> productRes;
}
