/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.models.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author rille
 */
public class CourseRepository {
    
    public List<Course> getCourses(int userId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        User user = (User)session.get(User.class, userId);
        List<Course> courses = user.getCourses();
        session.getTransaction().commit();
        session.close();
        return courses;

        
    }
    
}
