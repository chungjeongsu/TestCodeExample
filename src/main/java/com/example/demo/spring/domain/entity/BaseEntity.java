package com.example.demo.spring.domain.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.AuditingBeanDefinitionParser;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingBeanDefinitionParser.class)
public abstract class BaseEntity {
    @CreatedDate
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    private LocalDateTime modifiedDateTime;


}
