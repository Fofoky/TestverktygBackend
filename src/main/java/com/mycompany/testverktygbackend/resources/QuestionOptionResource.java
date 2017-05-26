package com.mycompany.testverktygbackend.resources;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.services.QuestionOptionService;
import com.mycompany.testverktygbackend.services.QuestionService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

 
@Path("/") 
public class QuestionOptionResource {
    
    
    
    @POST
    public QuestionOption addQuestionOption(@PathParam("questionId") int questionId, QuestionOption option) {
        System.out.println(option.isTrueFalse());
        QuestionService qs = new QuestionService();
        Question question = qs.getQuestion(questionId);
        option.setQuestion(question);
        QuestionOptionService qOs = new QuestionOptionService();
        return qOs.addQuestionOption(option);
    } 

}
