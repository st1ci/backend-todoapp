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

    public void updateTasks(String username,String tasks){

        Task task = new Task();

        task.setUsername(username);
        task.setTasks(tasks);

        taskRepository.save(task);
    }
}