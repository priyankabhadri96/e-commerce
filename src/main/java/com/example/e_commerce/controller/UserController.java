package com.example.e_commerce.controller;

import com.example.e_commerce.model.User;
import com.example.e_commerce.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User u){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userService.createUser(u));

    }

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
