package com.example.service.user;

public class Task {

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
