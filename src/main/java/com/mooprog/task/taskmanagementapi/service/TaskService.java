package com.mooprog.task.taskmanagementapi.service;

import com.mooprog.task.taskmanagementapi.exception.TaskNotFoundException;
import com.mooprog.task.taskmanagementapi.model.Task;
import com.mooprog.task.taskmanagementapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();

    }

    public Task getTaskById(Long id) {
        for (Task task : taskRepository.findAll()) {
            if (id.equals(task.getId())) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found with id: " + id);

    }


    public List<Task> getTasksByPriority(String priority) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            if (task.getPriority() != null && task.getPriority().equalsIgnoreCase(priority)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> getTasksNotCompleted(boolean completed) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            if (task.isCompleted() == completed) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public int numberOfTask() {
        return taskRepository.numberOfTask();

    }

    public Task updatedTask(Task updatedTask, Long id) {
        Task result = taskRepository.updatedTaskCompleted(updatedTask, id);
        if (result == null) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        return result;
    }

    public Task updatedTaskCompleted(Task updatedTask, Long id) {
        Task result = taskRepository.updatedTask(updatedTask, id);
        if (result == null) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        return result;
    }

    public void deltedTask(Long id) {
        boolean isDelted = taskRepository.deletedTask(id);
        if (!isDelted) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }

    }

}
