package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.services.QuestionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


 
@Path("/") 
@Produces(MediaType.APPLICATION_JSON)//Talar om att det finns metoder ska producera någonting, och vilken datatyp de har (kan också skrivas innan ensklida metoder)
@Consumes(MediaType.APPLICATION_JSON)//Detta gör att http kommer leta efter en post-metod
public class QuestionResources {
    QuestionService questionService = new QuestionService();
    
    @POST
    public Question addQuestion(@PathParam("testId") int testId, Question question){
        return questionService.addQuestion(testId, question);
    }
    
    @GET
    @Path("/{questionId}")
    public Question getQuestion(@PathParam("questionId") int questionId){
        return questionService.getQuestion(questionId);
    }
    
    @PUT
    @Path("/{questionId}")
    public Question updateQuestion(@PathParam("questionId") int questionId, Question question){
        question.setQuestionId(questionId);
        return questionService.updateQuestion(question);
    }
    
    @DELETE
    @Path("/{questionId}")
    public void deleteQuestion(@PathParam("questionId") int questionId){
        questionService.deleteQuestion(questionId);
    }
    
    
    @Path("/{questionId}/questionoption")
    public QuestionOptionResource questionOption() {
        return new QuestionOptionResource();
    }
    
    @Path("/{questionId}/responses")
    public ResponseResource response() {
        return new ResponseResource();
    }

}
