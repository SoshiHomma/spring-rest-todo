package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
    References:
    https://bezkoder.com/spring-boot-postgresql-example/
 */

@RestController
public class TodoController {

    @Autowired
    TodoRepository repository;

    @GetMapping("/api/todo")
    public ResponseEntity<List<Todo>> getAllTodo() {
        List<Todo> todoList = new ArrayList<>();

        // repository.findAll().forEach(todoList::add); を置き換えるとこうなる
        todoList.addAll(repository.findAll());

        if (todoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PostMapping("/api/todo")
    public ResponseEntity<Todo> createTodo(
            @RequestBody String content
    ) {
        try {
            Todo _todo = repository.save(new Todo(content));
            return new ResponseEntity<>(_todo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}