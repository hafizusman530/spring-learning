package com.usman.spring.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class TodoController {
    private final TaskRepository taskRepository;


    @Autowired
    public TodoController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //  @RequestBody
    //  @HttpEntity<Type>
    @RequestMapping(path = "/todo/tasks", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody Task task) {
        taskRepository.addTask(task);
        return new ResponseEntity<>("Task Created with id " + task.getId(), HttpStatus.OK);
    }

    @RequestMapping(path = "/todo/tasks", method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity<List<Task>> create() {
        List<Task> taskList = taskRepository.getTasks();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    ResponseEntity<String> helloWorld() {
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

}
