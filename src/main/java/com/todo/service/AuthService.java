package com.todo.service;

import com.todo.model.User;
import com.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

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

    public void recoverPassword(String username){

        User user = userRepository.findById(username).orElseThrow();

        String newPassword = generatePassword();

        user.setPassword(newPassword);

        userRepository.save(user);

        System.out.println("New password for "+username+" = "+newPassword);
    }

    private String generatePassword(){

        String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random rand = new Random();

        StringBuilder pass = new StringBuilder();

        for(int i=0;i<8;i++){
            pass.append(chars.charAt(rand.nextInt(chars.length())));
        }

        return pass.toString();
    }
}