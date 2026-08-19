package com.mooprog.task.taskmanagementapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private Long id;
    @NotBlank (message = "Title is mandatory")
    @Size(min = 3 , max = 100, message = "Title must be between 3 and 100 characters")

    private String title;

    @Size(min = 3 , max = 500, message = "Title must be between 3 and 500 characters")

    private String description;
    private boolean completed;

    @NotNull
    private String priority; //HIGH , MEDIUM , LOW
    private LocalDateTime createdAt;;

    public Task(Long id, String title, String description, boolean completed, String priority, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getPriority() {
        return priority;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


}
