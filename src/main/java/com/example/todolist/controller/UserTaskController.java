package com.example.todolist.controller;

import com.example.todolist.entity.Task;
import com.example.todolist.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserTaskController {
    @Autowired
    UserTaskService userTaskService;


    @GetMapping("user/{userId}/tasks")
    public Iterable<Task> getUserTasks(@PathVariable("userId") String userId){

        return userTaskService.getUserTasks(userId);
    }

    @PostMapping("user/{userId}/tasks")
    public Task createUserTasks( @PathVariable("userId") String userId,@RequestBody Task task){
        return userTaskService.createUserTasks(task);
    }

    @PutMapping("user/{userId}/tasks")
    public Task updateUserTask( @PathVariable("userId") String userId,@RequestBody Task task ){
        return userTaskService.updateUserTasks( task );
    }

    @GetMapping("user/{userId}/tasks/{taskId}")
    public ResponseEntity<Task> getUserTask(@PathVariable("userId") String userId, @PathVariable("taskId") Long taskId){
        Optional<Task> result = userTaskService.getUserTask(taskId);
        return ResponseEntity.of(result);
    }

    @DeleteMapping("user/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteUserTask(@PathVariable("userId") String userId, @PathVariable("taskId") Long taskId){
        boolean success = userTaskService.deleteUserTask(taskId);
        return success ? ResponseEntity.ok("success") : ResponseEntity.notFound().build();
    }
}
