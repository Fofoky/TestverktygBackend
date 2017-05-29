package com.mycompany.testverktygbackend.resources;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.services.QuestionOptionService;
import com.mycompany.testverktygbackend.services.QuestionService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

 
@Path("/questionoption") 
public class QuestionOptionResource {
    
    QuestionOptionService qOs = new QuestionOptionService();
    
    @GET
    public List<QuestionOption> getQuestionOption(@PathParam("questionId") int questionId){
        return qOs.getQuestionOption(questionId);
    }
    
    @POST
    public QuestionOption addQuestionOption(@PathParam("questionId") int questionId, QuestionOption option) {
        QuestionService qs = new QuestionService();
        Question question = qs.getQuestion(questionId);
        option.setQuestion(question);
        return qOs.addQuestionOption(option);
    } 

}
