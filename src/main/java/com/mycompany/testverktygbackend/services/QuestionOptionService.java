package com.mycompany.testverktygbackend.services;

// @author Anton

import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionOptionRepository;

 
public class QuestionOptionService {

    public QuestionOption addQuestionOption(QuestionOption option) {
        QuestionOptionRepository qOr = new QuestionOptionRepository();
        
        return qOr.addQuestionOption(option);
        
    }

}
