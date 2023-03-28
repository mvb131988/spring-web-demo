package com.example.demo.controller3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ UnsupportedMediaTypeStatusException.class })
    public final ResponseEntity<ApiError> handleException(UnsupportedMediaTypeStatusException ex, WebRequest request) {
        ApiError ae = new ApiError("CODE1", "Provided media type is not supported");
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(ae);
    }
    
    @ExceptionHandler({ IllegalArgumentException.class })
    public final ResponseEntity<ApiError> handleException(IllegalArgumentException ex, WebRequest request) {
        ApiError ae = new ApiError("CODE2", "Wrong api call");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ae);
    }
    
    @ExceptionHandler({ Exception.class })
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        ApiError ae = new ApiError("CODE3", "Smth went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ae);
    }
    
}
