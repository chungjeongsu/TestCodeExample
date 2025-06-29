package com.example.demo.spring.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
    // 글로벌 1000번대
    SUCCESS(HttpStatus.OK, 0, "정상 처리 되었습니다."),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, 1000, "잘못된 입력값입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, 1001, "유효하지 않은 토큰입니다."),
    REFRESH_TOKEN_REQUIRED(HttpStatus.UNAUTHORIZED, 1002, "Refresh Token이 필요합니다."),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 1003, "Refresh Token이 만료되었습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 1004, "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, 1005, "권한이 없는 사용자입니다."),
    DB_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1006, "DB 데이터 문제가 발생했습니다."),
    UNSUPPORTED_REQUEST(HttpStatus.NOT_FOUND, 1007, "존재하지 않는 요청입니다."),
    INVALID_FILE(HttpStatus.BAD_REQUEST, 1008, "지원하는 파일 형식이 아닙니다."),
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1009, "서버 시스템 문제가 발생했습니다."),
    NOT_FOUND_FILE(HttpStatus.NOT_FOUND, 1010, "파일을 찾을 수 없습니다."),
    MAXIMUM_UPLOAD_FILE_SIZE(HttpStatus.BAD_REQUEST, 1011, "사진은 최대 10MB, 영상은 최대 50MB 까지 가능합니다."),
    ;
    private final HttpStatus status;
    private final int code;
    private final String message;
}
