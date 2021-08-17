package com.example.service.controllers;

import com.example.service.repositories.UserRepository;
import com.example.service.user.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4210")
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

    @RequestMapping("/login")
    public boolean login (@RequestBody User user) {

        if (userRepository.existsById(user.getId())) {

            if (userRepository.findById(user.getId()).isPresent()) {
                User userInDB = userRepository.findById(user.getId()).get();

                if (userInDB.getUsername().equals(user.getUsername()))
                    return userInDB.getPassword() == user.getPassword();
            }
        }

        return false;
    }

    @RequestMapping("/user")
    public Principal user (HttpServletRequest request) {

        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();

        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }
}
