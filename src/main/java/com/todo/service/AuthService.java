package com.todo.service;

import com.todo.model.User;
import com.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(User user){

        Optional<User> existing = userRepository.findById(user.getUsername());

        if(existing.isPresent()){
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(user);
    }

    public User login(String username,String password){

        Optional<User> user = userRepository.findById(username);

        if(user.isEmpty()){
            throw new RuntimeException("User not found");
        }

        if(!user.get().getPassword().equals(password)){
            throw new RuntimeException("Wrong password");
        }

        return user.get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}