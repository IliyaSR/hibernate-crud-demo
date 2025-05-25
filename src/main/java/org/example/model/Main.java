package org.example.model;


import org.example.dao.CommentDAO;
import org.example.dao.TaskDAO;
import org.example.dao.UserDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        UserDAO userDAO = new UserDAO(sessionFactory);
        TaskDAO taskDAO = new TaskDAO(sessionFactory);
        CommentDAO commentDAO = new CommentDAO(sessionFactory);

        User user1 = new User("Alice Johnson", "alice@example.com");
        User user2 = new User("Bob Smith", "bob@example.com");

        userDAO.createUser(user1);
        userDAO.createUser(user2);

        Task task = new Task(
                "Write documentation",
                "Document all APIs for the new service",
                LocalDate.now(),
                LocalDate.parse("2024-01-01"),
                LocalDate.parse("2024-09-09"),
                Task.StatusEnum.TODO,
                userDAO.getUser(1)
        );

        taskDAO.createTask(task);

        Comment comment = new Comment(
                "Looks good! Just added validation for the date.",
                LocalDateTime.now(),
                taskDAO.getTask(1),
                userDAO.getUser(1)
        );

        commentDAO.createComment(comment);

        userDAO.updateUser(1, "John Smith", null);

        userDAO.deleteUser(2);

        taskDAO.updateTask(1, null, null, "DONE");

        commentDAO.updateComment(1, "Perfect!");

        commentDAO.deleteComment(1);
    }
}