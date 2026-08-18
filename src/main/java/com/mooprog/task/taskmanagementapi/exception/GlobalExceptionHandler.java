package com.mooprog.task.taskmanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// @RestControllerAdvice: Marks this class as a global error handler across all controllers
@RestControllerAdvice
public class GlobalExceptionHandler {
    // @ExceptionHandler: Tells Spring to call this method whenever TaskNotFoundException is thrown
    @ExceptionHandler
    public ResponseEntity<String> handleTaskNotException (TaskNotFoundException ex){
        // Return HTTP 404 (Not Found) with the error message in the response body
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
