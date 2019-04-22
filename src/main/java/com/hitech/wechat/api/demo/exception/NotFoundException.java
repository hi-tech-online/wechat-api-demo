package com.hitech.wechat.api.demo.exception;

/**
 * @author Steven
 */
public class NotFoundException extends GlobalException {
    public NotFoundException(String message, int code) {
        super(message, code);
    }
}
