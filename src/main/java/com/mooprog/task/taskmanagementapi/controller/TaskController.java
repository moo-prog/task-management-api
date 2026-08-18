package com.mooprog.task.taskmanagementapi.controller;

import com.mooprog.task.taskmanagementapi.model.Task;
import com.mooprog.task.taskmanagementapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
// @PathVariable: Pulls values directly from the URL path (e.g., /api/tasks/{id}).
// Best used to identify a specific resource.

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    // @RequestParam: Pulls query parameters from the URL after the '?' (e.g., /api/tasks/search?priority=HIGH).
    // Best used for filtering, searching, or sorting data.


    @GetMapping("/search")
    public List<Task> getTasksByPriority(@RequestParam String priority) {
        return taskService.getTasksByPriority(priority);
    }

    // @RequestBody: Converts the incoming HTTP request payload (JSON) into a Java object.
    // Best used for creating or updating resources with complex data (POST/PUT).
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {// <Task> means the response body will return the newly created Task object (with its generated ID and createdAt)
        Task created = taskService.createTask(task);
        // Return HTTP status 201 (Created) with the created task in the response body
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/search/status")
    public List<Task> getTasksNotCompleted(@RequestParam boolean completed) {
        return taskService.getTasksNotCompleted(completed);
    }

    @GetMapping("/numberOfTask")
    public int getNumberOfTasks() {
        return taskService.numberOfTask();
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Long id) {
        return taskService.updatedTask(task, id);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskCompleted(@RequestBody Task task, @PathVariable Long id) {
        return taskService.updatedTaskCompleted(task, id);
    }
    //or you can use @ResponseStatus(HttpStatus.NO_CONTENT) without to change the function
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {// <Void> means the HTTP response body is completely empty (no data returned)
        taskService.deltedTask(id);
        // If the task was successfully deleted, return HTTP status 204 (No Content)
        return ResponseEntity.noContent().build();
    }
}
