package com.example.demo.spring.business.order;

import com.example.demo.spring.business.order.dto.OrderCreateReq;
import com.example.demo.spring.business.order.dto.OrderCreateRes;
import com.example.demo.spring.domain.order.OrderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase{
    private final OrderManager orderManager;
    private final OrderMapper mapper;

    @Override
    public OrderCreateRes createOrder(OrderCreateReq orderCreateReq) {
        return null;
    }
}
