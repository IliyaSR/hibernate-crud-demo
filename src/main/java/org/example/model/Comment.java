package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Comment() {

    }

    public Comment(String text, LocalDateTime createdAt, Task task, User user) {
        this.text = text;
        this.createdAt = createdAt;
        this.task = task;
        this.user = user;
    }

    public void setText(String text){
        this.text = text;
    }
}
