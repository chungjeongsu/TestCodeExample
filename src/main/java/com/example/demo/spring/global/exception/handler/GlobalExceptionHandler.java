package com.example.demo.spring.global.exception.handler;

import com.example.demo.spring.global.exception.GlobalException;
import com.example.demo.spring.global.response.CommonRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // GlobalException 발생 시 반환 형태
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<CommonRes<Void>> handleException(GlobalException e) {
        return ResponseEntity.status(e.getResultCode().getStatus())
            .body(new CommonRes<>(e.getResultCode()));
    }
}
