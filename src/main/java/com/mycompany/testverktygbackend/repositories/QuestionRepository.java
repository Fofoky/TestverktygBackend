/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Question;
import com.mycompany.testverktygbackend.models.QuestionOption;
import com.mycompany.testverktygbackend.models.Response;
import com.mycompany.testverktygbackend.models.Test;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author rille
 */
public class QuestionRepository {
    
    TestRepository testRepository = new TestRepository();
    
    public Question addQuestion(int testId, Question question){
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        Question addQuestion = new Question();
        Test test = new Test();
        addQuestion.setQuestion(question.getQuestion());
        for(Test t : testRepository.getAllTest()){
            if(t.getIdTest()==testId){
                addQuestion.setTest(t);
            }
        }
        
        session.save(addQuestion);
        List<Response> responses=(List<Response>) question.getResponses();
        addQuestion.setResponses(responses);
        List<QuestionOption> questionOptions=(List<QuestionOption>) question.getQuestionOptions();
        addQuestion.setQuestionOptions(questionOptions);
        session.saveOrUpdate(addQuestion);
        
        session.getTransaction().commit();
        
        session.close();
        
        return addQuestion;
    }

}
