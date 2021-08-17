package com.example.service.user;

import java.util.List;

public class Category {

    private String categoryName;
    private List<Task> tasks;

    public Category (String name) {
        this.categoryName = name;
    }

    public String getCategoryName () {
        return this.categoryName;
    }

    public void setCategoryName (String name) {
        this.categoryName = name;
    }

    public List<Task> getTasks () {
        return this.tasks;
    }

    public void addTask (String name) {

        Task task = new Task(name);
        tasks.add(task);
    }
}
