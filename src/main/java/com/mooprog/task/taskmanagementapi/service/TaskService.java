package com.mooprog.task.taskmanagementapi.service;

import com.mooprog.task.taskmanagementapi.model.Task;
import com.mooprog.task.taskmanagementapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private  final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }
    public List<Task> getAllTask(){
        return taskRepository.findAll();

    }
    public Task getTaskById(Long id){
        for(Task task : taskRepository.findAll()){
            if (id.equals(task.getId())){
                return task;
            }
        }
        return null;
    }

    public List<Task> getTasksByPriority(String priority){
        List<Task> matchingTasks = new ArrayList<>();
        for(Task task : taskRepository.findAll()){
            if (task.getPriority() != null && task.getPriority().equalsIgnoreCase(priority)){
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
    public List<Task> getTasksNotCompleted(boolean completed){
        List<Task> matchingTasks = new ArrayList<>();
        for(Task task : taskRepository.findAll()){
            if (task.getPriority() != null && !task.isCompleted()){
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
    public int numberOfTask(){
        return taskRepository.numberOfTask();

    }
    public Task updatedTask(Task updatedTask, Long id) {
        return taskRepository.updatedTask(updatedTask, id);
    }
    public Task updatedTaskCompleted(Task updatedTask, Long id) {
        return taskRepository.updatedTaskCompleted(updatedTask, id);
    }
    public boolean deltedTask(Long id) {
        return taskRepository.deletedTask(id);
    }

}
