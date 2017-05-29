package com.mycompany.testverktygbackend.services;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionOptionRepository;
import java.util.List;

 
public class QuestionOptionService {
    QuestionOptionRepository optionRepository = new QuestionOptionRepository();

    public QuestionOption addQuestionOption(QuestionOption option) {
        return optionRepository.addQuestionOption(option);
        
    }

    public List<QuestionOption> getOptionOptions(int questionId) {
        QuestionService qS = new QuestionService();
        Question question = qS.getQuestion(questionId);
        return question.getQuestionOptions();
    }

    public QuestionOption updateOption(QuestionOption option, int questionId) {
        
        QuestionService qs = new QuestionService();
        Question question = qs.getQuestion(questionId);
        option.setQuestion(question);
        return optionRepository.updateOption(option);
    }

}
