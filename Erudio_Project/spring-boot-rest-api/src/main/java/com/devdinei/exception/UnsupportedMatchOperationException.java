package com.devdinei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMatchOperationException extends RuntimeException {
    public UnsupportedMatchOperationException(String message) {
        super(message);
    }
}
