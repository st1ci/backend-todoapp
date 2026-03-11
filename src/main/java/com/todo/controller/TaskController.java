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

    @PutMapping("/{username}")
    public void updateTasks(@PathVariable String username,
                            @RequestBody String tasks){

        taskService.updateTasks(username,tasks);
    }
}