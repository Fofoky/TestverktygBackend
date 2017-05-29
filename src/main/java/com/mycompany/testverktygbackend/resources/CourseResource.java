package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.Course;
import com.mycompany.testverktygbackend.services.CourseService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/") 
@Produces(MediaType.APPLICATION_JSON)//Talar om att det finns metoder ska producera någonting, och vilken datatyp de har (kan också skrivas innan ensklida metoder)
@Consumes(MediaType.APPLICATION_JSON)//Detta gör att http kommer leta efter en post-metod
public class CourseResource {
    CourseService courseService = new CourseService();
    
    @GET
    public List<Course> getCourses(@PathParam("userId") int userId){
        return courseService.getCourses(userId);
    }
    
    @Path("/{courseId}/tests")
    public TestResources test() {
        return new TestResources();
    }
}
