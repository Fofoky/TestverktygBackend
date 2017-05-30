/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend.model;

import java.io.Serializable;

/**
 *
 * @author Richard
 */
public class QuestionOption implements Serializable{
    
    private int questionOptionId;
    private boolean trueFalse;
    private String questionOption;
    
    private Question question;
    
    public QuestionOption(){}
    
    public QuestionOption(int questionOptionId, boolean trueFalse, String questionOption){
        this.questionOptionId = questionOptionId;
        this.trueFalse = trueFalse;
        this.questionOption = questionOption;
    }

    public int getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(int questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public boolean isTrueFalse() {
        return trueFalse;
    }

    public void setTrueFalse(boolean trueFalse) {
        this.trueFalse = trueFalse;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
}
