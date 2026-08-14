package com.example.e_commerce.controller;

import com.example.e_commerce.model.LoginRequest;
import com.example.e_commerce.model.LoginResponse;
import com.example.e_commerce.model.User;
import com.example.e_commerce.repository.UserRepository;
import com.example.e_commerce.service.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, JwtService jwtService,PasswordEncoder passwordEncoder){
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        User user = userRepository.findByName(request.getUsername());
        if(passwordEncoder.matches(request.getPassword(), user.getPassword())){
           String token = jwtService.generateToken(user.getName(),user.getRole());

           return new LoginResponse(token);

        }
        else{
            throw new RuntimeException("password did not match");
        }
    }
}
