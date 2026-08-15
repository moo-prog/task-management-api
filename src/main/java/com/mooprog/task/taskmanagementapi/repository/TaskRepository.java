package com.mooprog.task.taskmanagementapi.repository;

import com.mooprog.task.taskmanagementapi.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks =new ArrayList<>();
    private Long nextId=1L;


    public TaskRepository(){
        tasks.add(new Task(nextId++, "First Task", "Description of the first task", false, "HIGH",  LocalDateTime.now()));
        tasks.add(new Task(nextId++, "Second Task", "Description of the second task", true, "MEDIUM",  LocalDateTime.now()));

    }
    public Task save(Task task){
       task.setId(nextId++);
       tasks.add(task);
       return task;
    }
    public List<Task> findAll(){
       return tasks;
    }

    public int numberOfTask(){
        int sum=0;
            for (Task task : tasks){
                sum++;
            }
        return sum;
    }
    public Task updatedTask(Task updatedTask , Long id){
        for (Task t : tasks){
           if (t.getId().equals(id)) {
               t.setTitle(updatedTask.getTitle());
               t.setTitle(updatedTask.getTitle());
               t.setDescription(updatedTask.getDescription());
               t.setCompleted(updatedTask.isCompleted());
               t.setPriority(updatedTask.getPriority());
               t.setCreatedAt(updatedTask.getCreatedAt());
               return t;

           }
        }
        return null;

    }
    public Task updatedTaskCompleted(Task updatedTask , Long id){
        for (Task t : tasks){
            if (t.getId().equals(id)) {
                t.setCompleted(updatedTask.isCompleted());
                return t;
            }
        }
        return null;

    }

}
