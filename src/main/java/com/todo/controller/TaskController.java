package com.todo.controller;

import com.todo.model.Task;
import com.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }


}