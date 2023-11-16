package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController {
    ArrayList<Todo> todos = new ArrayList<>();

    @PostMapping
    public void addTodo (Todo todo){
        this.todos.add(todo);

    }
    @GetMapping
    public ArrayList<Todo>  getTodo ()
    {
        return todos;

    }
}
