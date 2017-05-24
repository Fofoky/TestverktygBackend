package com.mycompany.testverktygbackend.resources;

import javax.ws.rs.Path;

@Path("/courses")
public class CourseResource {
    
    
    
    
    
    @Path("/{courseId}/tests")
    public TestResources test() {
        return new TestResources();
    }
}
