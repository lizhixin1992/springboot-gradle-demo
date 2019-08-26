package com.example.demo.globalException;

import lombok.Data;

/**
 * @ClassName
 * @Description TODO
 * @Date 2019-08-26 15:23
 **/
@Data
public class BaseException extends RuntimeException {
    protected String errorMessage;

    protected Integer errorCode;

    protected String devMessage;

    public BaseException() {
    }

    public BaseException(String errorMessage, Integer errorCode, String devMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.devMessage = devMessage;
    }

    public static class customerException extends BaseException {

        public customerException(String errorMessage, Integer errorCode, String devMessage) {
            super(errorMessage, errorCode, devMessage);
        }
    }
}