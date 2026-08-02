package com.mooprog.task.taskmanagementapi.repository;

import com.mooprog.task.taskmanagementapi.model.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks =new ArrayList<>();
    private int nextId=1;

    public TaskRepository(){
        tasks.add(new Task(nextId++, "First Task", "Description of the first task", false, "HIGH", LocalDate.now()));
        tasks.add(new Task(nextId++, "Second Task", "Description of the second task", true, "MEDIUM", LocalDate.now().plusDays(2)));

    }
    public Task save(Task task){
       task.setId(nextId++);
       tasks.add(task);
       return task;
    }
    public List<Task> findAll(){
       return tasks;
    }


}
