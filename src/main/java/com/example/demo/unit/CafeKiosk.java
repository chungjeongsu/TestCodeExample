package com.example.demo.unit;

import com.example.demo.unit.order.Order;
import java.time.LocalTime;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cglib.core.Local;

/**
 * 1. 주문 목록에 음료 추가, 삭제 기능
 * 2. 주문 목록 전체 지우기
 * 3. 주문 목록 총 금액 계산하기
 * 4. 주문 생성하기
 */
@Getter
public class CafeKiosk {
    private static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
    private static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage){
        beverages.add(beverage);
    }

    public void add(Beverage beverage, int count){
        if(count <= 0) throw new IllegalArgumentException("음료는 1잔 이상 주문하실 수 있습니다.");

        for(int i = 0; i < count; i++){
            beverages.add(beverage);
        }
    }

    public void remove(Beverage beverage){
        beverages.remove(beverage);
    }

    public void clear(){
        beverages.clear();
    }

    /**
     * LocalDateTime을 의존하고 있는 createOrder
     * 테스트가 힘들다.
     */
    public Order createOrder(LocalDateTime currentDateTime){
        LocalTime currentTime = currentDateTime.toLocalTime();

        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)){
            throw new IllegalArgumentException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
        }

        return new Order(LocalDateTime.now(), beverages);
    }

    public int calculateTotalPrice(){
        return beverages.stream()
                .mapToInt(Beverage::getPrice)
                .sum();
    }
}
