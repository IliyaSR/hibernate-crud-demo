package org.example;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        UserDAO userDAO = new UserDAO(sessionFactory);


        Task task = new Task("shop", "Online shop", LocalDate.parse("2024-12-12"), LocalDate.parse("2024-12-20")
                , LocalDate.parse("2025-01-30"), Task.StatusEnum.TODO, userDAO.getUser(1));

        TaskDAO taskDAO = new TaskDAO(sessionFactory);

        taskDAO.createTask(task);
    }
}