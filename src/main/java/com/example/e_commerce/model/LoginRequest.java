package com.example.e_commerce.model;

import jakarta.persistence.Column;

public class LoginRequest {

    @Column(unique = true,nullable = false)
    String username;
    @Column(nullable = false)
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
