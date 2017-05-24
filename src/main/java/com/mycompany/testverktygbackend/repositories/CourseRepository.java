package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Course;
import org.hibernate.Session;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.models.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CourseRepository {

    Session session;

    public CourseRepository() {
        session = HibernateUtil.getSession();
    }

    public Course getCourse(int courseId) {
        Course course = (Course) session.get(Course.class, courseId);
        return course;
    }

    
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
