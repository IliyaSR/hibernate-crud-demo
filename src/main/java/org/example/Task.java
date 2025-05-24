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
    private LocalDate startDate;
    private LocalDate endDate;
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedTo;

    public Task() {

    }

    Task(String title, String description, LocalDate createdDate, LocalDate startDate,
         LocalDate endDate, StatusEnum status) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
