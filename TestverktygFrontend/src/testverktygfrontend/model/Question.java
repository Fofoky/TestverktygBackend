/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Richard
 */
public class Question implements Serializable {
    
    private int questionId;
    private String question;
    
    private Test test;
//    private List<Response> responses;
//    private List<QuestionOption> questionOptions;
    
    
    public Question(){}
    
    public Question(int questionId, String question){
        this.questionId = questionId;
        this.question = question;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

//    public List<Response> getResponses() {
//        return responses;
//    }
//
//    public void setResponses(List<Response> responses) {
//        this.responses = responses;
//    }
//
//    public List<QuestionOption> getQuestionOptions() {
//        return questionOptions;
//    }
//
//    public void setQuestionOptions(List<QuestionOption> questionOptions) {
//        this.questionOptions = questionOptions;
//    }
    
}
