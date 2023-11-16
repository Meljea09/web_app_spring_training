package fr.lernejo.todo;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

public class TodoEntity {

    @Id
    public Long id;

    public String message;

    public String author;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
