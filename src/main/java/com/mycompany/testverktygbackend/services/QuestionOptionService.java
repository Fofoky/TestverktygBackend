package com.mycompany.testverktygbackend.services;

// @author Anton

import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionOptionRepository;
import java.util.List;

 
public class QuestionOptionService {
    QuestionOptionRepository qOr = new QuestionOptionRepository();
    
    public QuestionOption addQuestionOption(QuestionOption option) {
        
        return qOr.addQuestionOption(option);
        
    }

    public List<QuestionOption> getQuestionOption() {
        return qOr.getQuestionOptions();
    }
    
    

}
