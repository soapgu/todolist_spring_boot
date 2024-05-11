package com.example.todolist.service;

import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTaskServiceImpl implements UserTaskService{
    private final Log log = LogFactory.getLog(UserTaskServiceImpl.class);

    @Autowired
    TaskRepository taskRepository;
    @Override
    public List<Task> getUserTasks(String userId) {
        log.info("getUserTasks userId:" + userId);
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
    public boolean deleteUserTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if(exists) {
            taskRepository.deleteById(taskId);
        }
        return exists;
    }
}
