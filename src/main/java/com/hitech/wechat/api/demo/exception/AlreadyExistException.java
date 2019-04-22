package com.hitech.wechat.api.demo.exception;

/**
 * @author Steven
 */
public class AlreadyExistException extends GlobalException {
    public AlreadyExistException(String message, int code) {
        super(message, code);
    }
}
