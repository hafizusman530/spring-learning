package com.usman.spring.learning;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface TaskRepository {
    List<Task> getTasks();

    void addTask(Task task);

    Task getTask(String id);

    void removeTask(String id);

    void updateTask(Task task);
}
