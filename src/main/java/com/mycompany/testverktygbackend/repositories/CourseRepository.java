package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Course;
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

}
