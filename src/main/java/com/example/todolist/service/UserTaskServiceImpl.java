package com.example.todolist.service;

import com.example.todolist.dto.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTaskServiceImpl implements UserTaskService{

    @Autowired
    TaskRepository taskRepository;
    @Override
    public List<Task> getUserTasks(String userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task createUserTasks(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateUserTasks(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getUserTask(Long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public void deleteUserTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
