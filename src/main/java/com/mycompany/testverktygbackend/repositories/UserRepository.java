
package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.User;
import org.hibernate.Session;

public class UserRepository {

    Session session;

    public UserRepository() {
        session = HibernateUtil.getSession();
    }

    public User addUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User getUser(int userId) {
        session.beginTransaction();
        User user = (User) session.get(User.class, userId);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
