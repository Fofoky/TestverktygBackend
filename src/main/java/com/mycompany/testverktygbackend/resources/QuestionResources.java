package com.mycompany.testverktygbackend.resources;

// @author Anton

import javax.ws.rs.Path;

 
class QuestionResources {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Path("/{questionId}/questionoption")
    public QuestionOptionResource questionOption() {
        return new QuestionOptionResource();
    }
    
    @Path("/{questionId}/responses")
    public ResponseResource response() {
        return new ResponseResource();
    }

}
