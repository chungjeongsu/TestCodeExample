package com.example.demo.unit;

import com.example.demo.unit.beverage.Americano;
import com.example.demo.unit.beverage.Latte;
import com.example.demo.unit.order.Order;
import java.time.LocalDateTime;

public class CateKioskRunner {
    public static void main(String[] args) {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        System.out.println(">>> 아메리카노 추가");
        cafeKiosk.add(new Latte());
        System.out.println(">>> 라떼 추가");

        int totalPrice = cafeKiosk.calculateTotalPrice();
        System.out.println("총 주문 가격 : " + totalPrice);

        Order order = cafeKiosk.createOrder(LocalDateTime.now());
    }
}
