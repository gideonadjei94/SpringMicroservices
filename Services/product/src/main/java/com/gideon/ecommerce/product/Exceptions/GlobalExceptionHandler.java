package com.gideon.ecommerce.product.Exceptions;

import com.gideon.ecommerce.product.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handle(ResourceNotFoundException e){
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ApiResponse(e.getMessage(),null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handle(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Extract field errors and their messages
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        // Create a response body
        ApiResponse response = new ApiResponse("Validation failed", errors);

        return ResponseEntity.status(BAD_REQUEST).body(response);
    }
}
