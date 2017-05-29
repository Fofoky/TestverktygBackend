package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.repositories.QuestionRepository;

/**
 *
 * @author rille
 */
public class QuestionService {

    QuestionRepository questionRepository = new QuestionRepository();

    public Question addQuestion(int testId, Question question) {
        return questionRepository.addQuestion(testId, question);
    }

    public Question getQuestion(int questionId) {
        return questionRepository.getQuestion(questionId);
    }

    public Question updateQuestion(Question question, int testId) {
        TestServices ts = new TestServices();
        
        Test test = ts.getTest(testId);
        question.setTest(test);
        
        return questionRepository.updateQuestion(question);
    }

    public void deleteQuestion(int questionId) {
        questionRepository.deleteQuestion(questionId);
    }
}
