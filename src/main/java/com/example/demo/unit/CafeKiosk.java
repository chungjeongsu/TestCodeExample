package com.example.demo.unit;

import com.example.demo.unit.order.Order;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 1. 주문 목록에 음료 추가, 삭제 기능
 * 2. 주문 목록 전체 지우기
 * 3. 주문 목록 총 금액 계산하기
 * 4. 주문 생성하기
 */
@Getter
public class CafeKiosk {
    private final List<Beverage> beverages = new ArrayList<>();
    public void add(Beverage beverage){
        beverages.add(beverage);
    }

    public void remove(Beverage beverage){
        beverages.remove(beverage);
    }

    public void clear(){
        beverages.clear();
    }

    public int calculateTotalPrice(){
        int totalPrice = 0;
        for (Beverage beverage : beverages) {
            totalPrice += beverage.getPrice();
        }
        return totalPrice;
    }

    public Order createOrder(){
        return new Order(LocalDateTime.now(), beverages);
    }
}
