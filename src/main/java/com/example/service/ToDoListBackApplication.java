package com.example.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

@SpringBootApplication
public class ToDoListBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListBackApplication.class, args);
    }

    @Bean
    CommandLineRunner init (UserRepository userRepository) {

        return args -> {
            Stream.of("pharrelson", "eturner", "cespinoza").forEach(name -> {
                User user = null;
                try {
                    user = new User(name, name.toLowerCase() + "@gmail.com", "Jd1789rf-2");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                assert user != null;
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
