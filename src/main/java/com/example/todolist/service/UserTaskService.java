package com.example.todolist.service;

import com.example.todolist.dto.Task;

import java.util.List;
import java.util.Optional;

public interface UserTaskService {
    List<Task> getUserTasks(String userId);
    Task createUserTasks(Task task);

    Task updateUserTasks(Task task);

    Optional<Task> getUserTask(Long taskId);

    boolean deleteUserTask(Long taskId);
}
