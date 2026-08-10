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

}
