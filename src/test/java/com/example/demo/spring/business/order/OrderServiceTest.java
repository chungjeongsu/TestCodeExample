package com.example.demo.spring.business.order;

import static com.example.demo.spring.domain.product.entity.ProductSellingStatus.HOLD;
import static com.example.demo.spring.domain.product.entity.ProductSellingStatus.SELLING;
import static com.example.demo.spring.domain.product.entity.ProductSellingStatus.STOP_SELLING;

import com.example.demo.spring.business.order.dto.OrderCreateReq;
import com.example.demo.spring.business.order.dto.OrderCreateRes;
import com.example.demo.spring.domain.product.entity.Product;
import com.example.demo.spring.domain.product.entity.ProductType;
import com.example.demo.spring.infra.jpa.product.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
class OrderServiceTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderService orderService;

    @DisplayName("주문번호 리스트를 받아 주문을 생성한다.")
    @Test
    void createOrder(){
        //given
        Product product1 = Product.builder()
                .productNumber("001")
                .type(ProductType.HANDMADE)
                .sellingStatus(SELLING)
                .name("아메리카노")
                .price(4000)
                .build();

        Product product2 = Product.builder()
                .productNumber("002")
                .type(ProductType.HANDMADE)
                .sellingStatus(HOLD)
                .name("카페라때")
                .price(4000)
                .build();

        Product product3 = Product.builder()
                .productNumber("003")
                .type(ProductType.HANDMADE)
                .sellingStatus(STOP_SELLING)
                .name("팥빙수")
                .price(7000)
                .build();
        productRepository.saveAll(List.of(product1, product2, product3));

        OrderCreateReq req = OrderCreateReq.builder()
                .productNumbers(List.of("001", "002"))
                .build();

        //when
        OrderCreateRes orderCreateRes = orderService.createOrder(req);

        //then
        Assertions.assertThat(orderCreateRes.getId()).isNotNull();
        Assertions.assertThat(orderCreateRes)
                .extracting("registeredDateTime", "totalPrice")
                .contains(LocalDateTime.now(), 8000);   //여기서 에러 발생하는듯
        Assertions.assertThat(orderCreateRes.getProductRes()).hasSize(2)
                .extracting("productNumber", "price")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("001", 1000),
                        Tuple.tuple("002", 3000)
                );
    }
}