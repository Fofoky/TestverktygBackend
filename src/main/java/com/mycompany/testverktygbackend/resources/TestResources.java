package com.mycompany.testverktygbackend.resources;

import javax.ws.rs.Path;




@Path("/tests")
public class TestResources {
    
    
    
    
    
   @Path("/{testId}/questions")
    public QuestionResources question() {
        return new QuestionResources();
    }
}
