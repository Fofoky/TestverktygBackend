package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.repositories.QuestionRepository;
import java.util.List;

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
        List<Test> tests = ts.getAllTests();
        
        for(Test test : tests){
            if(test.getIdTest() == testId){
                question.setTest(test);
            }
        }
        
        return questionRepository.updateQuestion(question);
    }

    public void deleteQuestion(int questionId) {
        questionRepository.deleteQuestion(questionId);
    }
}
