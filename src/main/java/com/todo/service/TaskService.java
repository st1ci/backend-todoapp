package com.todo.service;

import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public String getTasks(String username){

        Optional<Task> tasks = taskRepository.findById(username);

        if(tasks.isPresent()){
            return tasks.get().getTasks();
        }

        return "[]";
    }

    public void saveTasks(String username,String tasksJson){

        Task task = taskRepository.findById(username)
                .orElse(new Task());

        task.setUsername(username);
        task.setTasks(tasksJson);

        taskRepository.save(task);
    }
}