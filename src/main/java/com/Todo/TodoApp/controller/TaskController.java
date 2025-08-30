package com.Todo.TodoApp.controller;

import com.Todo.TodoApp.model.Task;
import com.Todo.TodoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

//    public TaskController(TaskService taskService) {
//        this.taskService = taskService;
//    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.findAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return"redirect:/tasks";
    }
    @GetMapping("/{id}/delete")
    public String getTasks(@PathVariable Long id){
        taskService.deleteTask(id);
        return"redirect:/tasks";
    }
    @GetMapping("/{id}/toggle")
    public String getToggledTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return"redirect:/tasks";
    }
}
