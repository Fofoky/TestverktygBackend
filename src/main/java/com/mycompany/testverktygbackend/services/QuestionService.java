package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.repositories.QuestionRepository;

/**
 *
 * @author rille
 */
public class QuestionService {
    QuestionRepository questionRepository = new QuestionRepository();
    
    public Question addQuestion(int testId, Question question){
        return questionRepository.addQuestion(testId, question);
    }

    public Question getQuestion(int questionId) {
        QuestionRepository qr = new QuestionRepository();
        return qr.getQuestion(questionId);
    }
}
