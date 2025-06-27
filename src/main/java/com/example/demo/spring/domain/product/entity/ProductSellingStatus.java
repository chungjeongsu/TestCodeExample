package com.example.demo.spring.domain.product.entity;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductSellingStatus {
    SELLING("판매 중"),
    HOLD("판매 보류"),
    STOP_SELLING("판매 중지");

    private final String text;

    public static List<ProductSellingStatus> forDisplay() {
        return List.of(SELLING, HOLD);
    }
}
