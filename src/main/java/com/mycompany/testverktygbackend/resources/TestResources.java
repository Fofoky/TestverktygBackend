package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.repositories.CourseRepository;
import com.mycompany.testverktygbackend.services.TestServices;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/tests")
public class TestResources {

    @POST
    public Test addTest(@PathParam("courseId") int courseId, Test test) {
        CourseRepository cs = new CourseRepository();
        Course course = cs.getCourse(courseId);
        test.setCourse(course);
        TestServices ts = new TestServices();
        return ts.addTest(test);
    }

    @Path("/{testId}/questions")
    public QuestionResources question() {
        return new QuestionResources();
    }
}
