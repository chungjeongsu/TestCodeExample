package com.example.demo.spring.presentation.order;

import com.example.demo.spring.business.order.OrderService;
import com.example.demo.spring.business.order.dto.OrderCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/v1/order/new")
    public void createOrder(
            @RequestBody OrderCreateReq orderCreateReq
    ){
        orderService.createOrder(orderCreateReq);
    }
}
