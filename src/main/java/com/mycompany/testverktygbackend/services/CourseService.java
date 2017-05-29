package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.models.User;
import com.mycompany.testverktygbackend.repositories.CourseRepository;
import java.util.List;

/**
 *
 * @author rille
 */
public class CourseService {
    CourseRepository courseRepository = new CourseRepository();
    
    public List<Course> getCourses(int userId){
        UserService us = new UserService();
        List<User> users = us.getUsers();
        List<Course> courses = null;
        for(User user: users){
            if(user.getUserId() == userId){
                courses = user.getCourses();
            }
        }
        
        return courses;
    }
    
}
