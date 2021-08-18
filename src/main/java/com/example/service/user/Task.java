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
    private String title;
    boolean completed;

    public Task (String taskDesc) {

        this.title = taskDesc;
        this.completed = false;
    }

    public Task() {
        this.title = "";
        this.completed = false;
    }

    public void setTaskDesc (String task) {
        this.title = task;
    }

    public String getTaskDesc () {
        return this.title;
    }

    public boolean getCompleted () {
        return this.completed;
    }

    public void setCompleted () {
        this.completed = !completed;
    }

    @Override
    public String toString () {
        return "Task Desc: {" + this.title + ", Completed: " + this.completed + "}";
    }
}
