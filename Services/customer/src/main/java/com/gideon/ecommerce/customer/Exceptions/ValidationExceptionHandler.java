package com.gideon.ecommerce.customer.Exceptions;

import com.gideon.ecommerce.customer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handle(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Extract field errors and their messages
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        // Create a response body
        ApiResponse response = new ApiResponse("Validation failed", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
