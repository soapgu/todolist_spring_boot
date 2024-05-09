package com.example.todolist.repository;

import com.example.todolist.dto.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Long> {
    List<Task> findByUserId(String userId);
}
