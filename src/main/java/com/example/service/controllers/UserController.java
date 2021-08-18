package com.example.service.controllers;

import com.example.service.repositories.TaskRepository;
import com.example.service.repositories.UserRepository;
import com.example.service.user.Task;
import com.example.service.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserController (UserRepository userRepository,
                           TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers () {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/tasks")
    public List<Task> getTasks () {
        return (List<Task>) taskRepository.findAll();
    }

    @PostMapping("/users")
    void addUser (@RequestBody User user) {
        userRepository.save(user);
    }
}
