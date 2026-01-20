package com.binal.country.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Errorresponse {

    private String message;
    private  int status;
    private LocalDateTime timestamp;

    public Errorresponse(String message, int status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}
