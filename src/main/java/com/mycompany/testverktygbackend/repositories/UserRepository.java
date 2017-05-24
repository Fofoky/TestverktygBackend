/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.User;
import org.hibernate.Session;

public class UserRepository {

    public User addUser(User user) {
        System.out.println("UserRepository addUser");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
    
    public User getUser(int userId){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User)session.get(User.class, userId);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
