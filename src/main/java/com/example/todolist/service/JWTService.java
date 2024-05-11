package com.example.todolist.service;

public interface JWTService {
    String createToken(String userId);
    String verifyToken(String token);
}
