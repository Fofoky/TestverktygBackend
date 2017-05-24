package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.services.QuestionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


 
@Path("/") 
@Produces(MediaType.APPLICATION_JSON)//Talar om att det finns metoder ska producera någonting, och vilken datatyp de har (kan också skrivas innan ensklida metoder)
@Consumes(MediaType.APPLICATION_JSON)//Detta gör att http kommer leta efter en post-metod
class QuestionResources {
    QuestionService questionService = new QuestionService();
    
    @POST
    public Question addQuestion(@PathParam("testId") int testId, Question question){
        System.out.println("Kommer in i addQuestion i resource.");
        return questionService.addQuestion(testId, question);
    }
}
