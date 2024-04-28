package com.example.todolist.controller;

import com.example.todolist.dto.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserTaskController {
    @Autowired
    TaskRepository taskRepository;


    @GetMapping("user/{userId}/tasks")
    public Iterable<Task> getUserTasks(@PathVariable("userId") String userId){
        /*
        List<Task> list = new ArrayList<>();
        Task task = new Task();
        task.setUserId( userId );
        task.setCreateTime(new Date());
        task.setUpdateTime(new Date());
        task.setDeadline( Date.from(Instant.now().plus(1, ChronoUnit.DAYS)));
        task.setContent("do some job...");
        list.add(task);
         */
        return taskRepository.findAll();
    }

    @PostMapping("user/{userId}/tasks")
    public Task createUserTasks( @PathVariable("userId") String userId,@RequestBody Task task){
        return taskRepository.save( task );
    }
}
