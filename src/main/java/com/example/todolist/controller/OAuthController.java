package com.example.todolist.controller;

import com.example.todolist.dto.UserAuth;
import com.example.todolist.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OAuthController {

    @Autowired
    JWTService jwtService;
    @PostMapping("oauth/token")
    public ResponseEntity<Map<String,String>> login(@RequestBody UserAuth auth){
        if( auth.isVaild() ){
            String token = jwtService.createToken( auth.getUserId() );
            Map<String, String> map = new HashMap<>();
            map.put("access_token",token);
            return ResponseEntity.ok( map );
        }
        return ResponseEntity.badRequest().build();
    }
}
