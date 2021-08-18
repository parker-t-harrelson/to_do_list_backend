package com.example.service.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String taskDesc;
    boolean completed;

    public Task (String taskDesc) {

        this.taskDesc = taskDesc;
        this.completed = false;
    }

    public void setTaskDesc (String task) {
        this.taskDesc = task;
    }

    public String getTaskDesc () {
        return this.taskDesc;
    }

    public boolean getCompleted () {
        return this.completed;
    }

    public void setCompleted () {
        this.completed = !completed;
    }
}
