package com.example.demo.spring.domain.order;

import com.example.demo.spring.infra.jpa.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderManager {
    private final OrderRepository orderRepository;
}
