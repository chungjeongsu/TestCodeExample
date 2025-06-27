package com.example.demo.spring.global.exception;

import com.example.demo.spring.global.response.ResultCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GlobalException extends RuntimeException {
    private final ResultCode resultCode;
}
