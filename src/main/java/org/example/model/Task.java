package org.example.model;

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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Task() {

    }

    Task(String title, String description, LocalDate createdDate, LocalDate startDate,
         LocalDate endDate, StatusEnum status, User user) {
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.user = user;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(String status){
        this.status = StatusEnum.valueOf(status);
    }
}
