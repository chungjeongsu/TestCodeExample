package com.example.demo.spring.business.order;

import com.example.demo.spring.business.order.dto.OrderCreateReq;
import com.example.demo.spring.business.order.dto.OrderCreateRes;
import com.example.demo.spring.domain.order.OrderManager;
import com.example.demo.spring.domain.product.ProductManager;
import com.example.demo.spring.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase{
    private final OrderManager orderManager;
    private final ProductManager productManager;
    private final OrderMapper mapper;

    @Override
    public OrderCreateRes createOrder(OrderCreateReq orderCreateReq) {
        List<String> productNumbers = orderCreateReq.getProductNumbers();
        List<Product> products = productManager.findAllByProductNumber(productNumbers);
        return null;
    }
}
