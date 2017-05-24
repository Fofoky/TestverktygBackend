/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.repositories.CourseRepository;
import java.util.List;

/**
 *
 * @author rille
 */
public class CourseService {
    CourseRepository courseRepository = new CourseRepository();
    
    public List<Course> getCourses(int userId){
        return courseRepository.getCourses(userId);
    }
    
}
