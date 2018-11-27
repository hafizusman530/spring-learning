package com.usman.spring.learning;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void removeTask(String id) {
        taskList.addAll(
                taskList.stream()
                        .filter(task -> task.getId().equals(id))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public void updateTask(Task toUpdate) {
        taskList.addAll(
                taskList.stream()
                        .filter(task -> task.getId().equals(toUpdate.getId()))
                        .collect(Collectors.toList())
        );
    }
}
