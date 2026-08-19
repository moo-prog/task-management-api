package com.mooprog.task.taskmanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// @RestControllerAdvice: Marks this class as a global error handler across all controllers
@RestControllerAdvice
public class GlobalExceptionHandler {
    // @ExceptionHandler: Tells Spring to call this method whenever TaskNotFoundException is thrown
    @ExceptionHandler
    public ResponseEntity<String> handleTaskNotFoundException (TaskNotFoundException ex){
        // Return HTTP 404 (Not Found) with the error message in the response body
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    //validation (for bad request like when you don't write titel)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->

                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
