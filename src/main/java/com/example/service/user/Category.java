package com.example.service.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String categoryName;
    private ArrayList<Task> tasks;

    public Category (String name) {
        this.categoryName = name;
    }

    public String getCategoryName () {
        return this.categoryName;
    }

    public void setCategoryName (String name) {
        this.categoryName = name;
    }

    public ArrayList<Task> getTasks () {
        return this.tasks;
    }

    public void addTask (String name) {

        Task task = new Task(name);
        tasks.add(task);
    }
}
