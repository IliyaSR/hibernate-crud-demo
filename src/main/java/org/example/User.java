package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;


    User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {

    }
}
