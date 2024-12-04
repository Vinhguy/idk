package com.Movieweb.Exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001,"User existed"),
    LMAO(1000,"HAHA"),
    USER_NOT_EXISTED(1002,"User not existed");

    ErrorCode(int code, String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;
}
