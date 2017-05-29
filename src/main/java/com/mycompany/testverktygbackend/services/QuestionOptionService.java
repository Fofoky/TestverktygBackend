package com.mycompany.testverktygbackend.services;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionOptionRepository;
import java.util.List;

 
public class QuestionOptionService {

    public QuestionOption addQuestionOption(QuestionOption option) {
        QuestionOptionRepository qOr = new QuestionOptionRepository();
        
        return qOr.addQuestionOption(option);
        
    }

    public List<QuestionOption> getOptionOptions(int questionId) {
        QuestionService qS = new QuestionService();
        Question question = qS.getQuestion(questionId);
        return question.getQuestionOptions();
    }

}
