package com.mootez.resvervation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mootez.resvervation.authentication.user.UserRepository;
import com.mootez.resvervation.model.User;


@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow();
    }
    public User updateUser (User user){
        return userRepository.save(user);
    }
    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    
}