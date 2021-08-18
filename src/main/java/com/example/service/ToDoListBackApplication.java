package com.example.service;

import com.example.service.repositories.TaskRepository;
import com.example.service.user.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ToDoListBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListBackApplication.class, args);
    }

    @Bean
    CommandLineRunner init (TaskRepository taskRepository) {
        return args -> {
            Stream.of("Go outside and go for a walk and then cut the grass",
                      "Hang out with Evan and take her to the movies",
                      "Do homework that is due tomorrow",
                      "Finish up this sprint for work so that we can get done",
                      "Give Evan a big kiss").forEach(
                       task -> {
                           Task task1 = new Task(task);
                           taskRepository.save(task1);
                       });
            Iterable<Task> tas = taskRepository.findAll();

            for (Task t : tas)
                System.out.println(t.toString());
        };

    }

}
