package com.LockerService.Locker.Service.Management.Exception;

import org.springframework.http.HttpStatus;

public class LockerServiceAPIException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public LockerServiceAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public LockerServiceAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
