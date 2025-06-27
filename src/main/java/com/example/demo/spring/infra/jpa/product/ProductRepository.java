package com.example.demo.spring.infra.jpa.product;

import com.example.demo.spring.domain.product.entity.Product;
import com.example.demo.spring.domain.product.entity.ProductSellingStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * SELECT *
     * FROM product
     * WHERE selling_type in ('SELLING', 'HOLD')
     */
    List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingTypeList);
}
