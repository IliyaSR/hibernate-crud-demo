package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    enum StatusEnum {
        TODO,
        IN_PROGRESS,
        DONE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private LocalDate createdDate;
    private LocalDate dualDate;
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedTo;

    Task(String title, String description, LocalDate createdDate,
         LocalDate dualDate, StatusEnum status) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.dualDate = dualDate;
        this.status = status;
    }
}
