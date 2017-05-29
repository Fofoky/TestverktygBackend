package com.mycompany.testverktygbackend.resources;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.services.QuestionOptionService;
import com.mycompany.testverktygbackend.services.QuestionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
@Path("/questionoption") 
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionOptionResource {
    
    QuestionOptionService optionService = new QuestionOptionService();
    
    
    @POST
    public QuestionOption addQuestionOption(@PathParam("questionId") int questionId, QuestionOption option) {
        QuestionService qs = new QuestionService();
        Question question = qs.getQuestion(questionId);
        option.setQuestion(question);
        return optionService.addQuestionOption(option);
    } 
    
    @GET
    public List<QuestionOption> getOption(@PathParam("questionId") int questionId){
        return optionService.getOptionOptions(questionId);
    }

}
