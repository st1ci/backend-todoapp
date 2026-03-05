package com.todo.controller;

import com.todo.model.User;
import com.todo.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return authService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User request){
        return authService.login(request.getUsername(), request.getPassword());
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return authService.getAllUsers();
    }
}