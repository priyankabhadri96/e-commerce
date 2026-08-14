package com.example.e_commerce.service;

import com.example.e_commerce.model.User;
import com.example.e_commerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public User updateUser(Long id, User user){
      User u =  userRepository.findById(id).stream().findFirst().orElseThrow(()->
                new RuntimeException("user with "+id+" not found"));
      u.setName(user.getName());
      u.setRole(user.getRole());

        return userRepository.save(u);
    }
    public void deleteUser(Long id){
        User u =  userRepository.findById(id).stream().findFirst().orElseThrow(()->
                new RuntimeException("user with "+id+" not found"));

      userRepository.deleteById(id);
    }

    public User createUser(User u){
       return userRepository.save(u);
    }
}
