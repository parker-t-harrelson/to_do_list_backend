package com.example.service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4210/adduser")
public class UserController {

    private final UserRepository userRepository;

    public UserController (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers () {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser (@RequestBody User user) {
        userRepository.save(user);
    }
}
