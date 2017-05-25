package com.mycompany.testverktygbackend.resources;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionRepository;
import com.mycompany.testverktygbackend.services.QuestionOptionService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

 
@Path("/") 
public class QuestionOptionResource {
    
    
    
    @POST
    public QuestionOption addTest(@PathParam("questionId") int questionId, QuestionOption option) {
        QuestionRepository qs = new QuestionRepository();
        Question question = qs.getQuestion(questionId);
        option.setQuestion(question);
        QuestionOptionService qOs = new QuestionOptionService();
        return qOs.addQuestionOption(option);
    } 

}
