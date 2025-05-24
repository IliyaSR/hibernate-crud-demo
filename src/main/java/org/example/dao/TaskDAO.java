package org.example;

import org.example.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TaskDAO {
    private SessionFactory sessionFactory;

    TaskDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createTask(Task task) {
        Transaction tx = null;

        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(task);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
