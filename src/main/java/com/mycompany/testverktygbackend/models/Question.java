/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue
    private int questionId;
    private String question;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    private Test test;
    
    @OneToOne
    @JsonBackReference
    @JsonIgnore
    private Response response;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    List<QuestionOption> questionOptions;

    public Question() {
    }

    public Question(int questionId, String question) {
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

    public void setTest(Test test) {
        this.test = test;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }

}
