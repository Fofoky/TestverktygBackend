/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.models;

import java.util.List;


public class Question {
    private int questionId;
     
    Test test;
    Response response;
    
    List<QuestionOption> questionOptions;
    
    public Question(){}
    

    public Question(int questionId, Test test, Response response, <any> questionOptions) {
        this.questionId = questionId;
        this.test = test;
        this.response = response;
        this.questionOptions = questionOptions;
    }
    
    
    
}
