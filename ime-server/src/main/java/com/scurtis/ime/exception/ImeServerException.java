package com.scurtis.ime.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ImeServerException extends RuntimeException {

    private final HttpStatus status;
    private final String original;

    public ImeServerException(HttpStatus status, String message, String original) {
        super(message);
        this.status = status;
        this.original = original;
    }

}
