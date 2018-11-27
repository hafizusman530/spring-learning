package com.usman.spring.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(path = "/todo/tasks")
public class TodoController {
    private final TaskRepository taskRepository;


    @Autowired
    public TodoController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody Task task) {
        taskRepository.addTask(task);
        return new ResponseEntity<>("Task Created with id " + task.getId(), HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<String> update(@RequestBody Task task) {
        taskRepository.updateTask(task);
        return new ResponseEntity<>("Task updated with id " + task.getId(), HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity<String> delete(@PathVariable String taskId) {
        taskRepository.removeTask(taskId);
        return new ResponseEntity<>("Task Removed with id " + taskId, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<Task>> get() {
        List<Task> taskList = taskRepository.getTasks();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<Task> getSpecificTask(@PathVariable String taskId) {
        Task task = taskRepository.getTask(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }


}
