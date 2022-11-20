package com.pe.petelosz.exception;

import org.springframework.http.HttpStatus;

public class CustomMessageException extends RuntimeException {



    private HttpStatus httpStatus;
    private String message;

    public CustomMessageException(String message, HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
