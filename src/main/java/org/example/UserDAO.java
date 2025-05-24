package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {

    private SessionFactory sessionFactory;

    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public void createUser(User user) {
        Transaction tx = null;

        try(Session session = sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            throw e;
        }
    }

}
