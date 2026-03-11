package com.todo.controller;

import com.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/{username}")
    public String getTasks(@PathVariable String username){
        return taskService.getTasks(username);
    }

    @PostMapping("/{username}")
    public void saveTasks(@PathVariable String username,
                          @RequestBody String tasks){

        taskService.saveTasks(username,tasks);
    }
}