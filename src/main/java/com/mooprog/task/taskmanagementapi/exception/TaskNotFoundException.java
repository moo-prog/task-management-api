package com.mooprog.task.taskmanagementapi.exception;
/**
 * A custom exception class used across the application.
 * It is thrown when a task with a specific ID is not found in the database.
 */
public class TaskNotFoundException  extends RuntimeException{
    
    public TaskNotFoundException(String message) {
        super(message);
    }
}
