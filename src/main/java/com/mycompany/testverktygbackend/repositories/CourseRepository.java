package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.models.User;
import java.util.List;
import org.hibernate.Session;

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
        
        session.beginTransaction();
        
        User user = (User)session.get(User.class, userId);
        List<Course> courses = user.getCourses();
        session.getTransaction().commit();
        session.close();
        return courses;

        
    }
    
}
