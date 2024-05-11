package com.example.todolist.dto;

public class UserAuth {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVaild(){
        return password != null && !password.isEmpty() && userId != null && !userId.isEmpty();
    }
}
