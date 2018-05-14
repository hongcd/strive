package com.hongcd.strive.common.exception;

import lombok.Getter;

public class BusinessException extends RuntimeException {
    @Getter
    private Integer code;

    public BusinessException() {}
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public BusinessException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }
}