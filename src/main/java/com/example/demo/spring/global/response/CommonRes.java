package com.example.demo.spring.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class CommonRes<T> {
    private final Integer statusCode;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;

    public CommonRes(ResultCode resultCode) {
        this.statusCode = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    // 성공 시 일반적인 생성자
    public CommonRes(ResultCode resultCode, T data) {
        this.statusCode = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    // 이거 호출로 성공 생성자 자동 호출, 데이터 담아서 반환됨
    public static <T> CommonRes<T> success(T data) {
        return new CommonRes<>(ResultCode.SUCCESS, data);
    }
}
