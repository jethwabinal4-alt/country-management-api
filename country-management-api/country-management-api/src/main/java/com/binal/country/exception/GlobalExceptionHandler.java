package com.binal.country.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<Errorresponse> handleResourceFound(ResourceFoundException resourceFoundException){

        Errorresponse errorresponse =
                new Errorresponse(resourceFoundException.getMessage(), HttpStatus.FOUND.value(), LocalDateTime.now());

        return new ResponseEntity<>(errorresponse,HttpStatus.FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Errorresponse> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException){

        Errorresponse errorresponse =
                new Errorresponse(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());

        return new ResponseEntity<>(errorresponse,HttpStatus.NOT_FOUND);
    }
}
