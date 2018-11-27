package com.usman.spring.learning;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskRepositoryImp implements TaskRepository {
    private static List<Task> taskList;

    static {
        taskList = new ArrayList<>();
    }

    @Override
    public List<Task> getTasks() {
        return taskList;
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public Task getTask(String id) {
        return null;
    }

    @Override
    public void removeTask(String id) {

    }

    @Override
    public void updateTask(Task task) {

    }
}
