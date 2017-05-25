/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
