package com.mycompany.testverktygbackend.services;

// @author Anton

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.repositories.QuestionOptionRepository;
import java.util.List;

 
public class QuestionOptionService {
    QuestionOptionRepository optionRepository = new QuestionOptionRepository();

    public QuestionOption addQuestionOption(QuestionOption option) {
        System.out.println("QuesitonOptionService");
        return optionRepository.addQuestionOption(option);
        
    }

    public List<QuestionOption> getOptionOptions(int questionId, int testId) {
        QuestionService qs = new QuestionService();
        Question question = null;
        List<Question> questions = qs.getQuestions(testId);
        for(Question q : questions){
            if(q.getQuestionId() == questionId){
                question = q;
            }
        }
        
        return question.getQuestionOptions();
    }

    public QuestionOption updateOption(QuestionOption option, int questionId, int testId) {
        
        QuestionService qs = new QuestionService();
        List<Question> questions = qs.getQuestions(testId);
        for(Question q : questions){
            if(q.getQuestionId() == questionId){
                option.setQuestion(q);
            }
        }
        
        return optionRepository.updateOption(option);
    }

}
