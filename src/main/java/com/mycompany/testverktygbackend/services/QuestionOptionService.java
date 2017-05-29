package com.mycompany.testverktygbackend.services;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionOptionRepository;
import com.mycompany.testverktygbackend.repositories.QuestionRepository;
import java.util.List;

 
public class QuestionOptionService {
    QuestionOptionRepository qOr = new QuestionOptionRepository();
    
    public QuestionOption addQuestionOption(QuestionOption option) {
        
        return qOr.addQuestionOption(option);
        
    }

    public List<QuestionOption> getQuestionOption(int questionId) {
        QuestionRepository qR = new QuestionRepository();
        Question question = qR.getQuestion(questionId);
        List<QuestionOption> options = question.getQuestionOptions();
        return options;
        
    }
    
    

}
