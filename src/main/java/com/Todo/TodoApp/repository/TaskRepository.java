package com.Todo.TodoApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Todo.TodoApp.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
