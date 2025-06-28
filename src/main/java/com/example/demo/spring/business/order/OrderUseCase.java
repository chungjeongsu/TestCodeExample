package com.example.demo.spring.business.order;

import com.example.demo.spring.business.order.dto.OrderCreateReq;
import com.example.demo.spring.business.order.dto.OrderCreateRes;

public interface OrderUseCase {
    OrderCreateRes createOrder(OrderCreateReq orderCreateReq);
}
