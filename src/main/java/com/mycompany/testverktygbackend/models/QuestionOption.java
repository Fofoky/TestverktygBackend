package com.mycompany.testverktygbackend.models;

// @author Anton
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class QuestionOption implements Serializable {

    @Id
    @GeneratedValue
    private int questionOptionId;
    private boolean trueFalse;
    private String questionOption;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    Question question;

    public QuestionOption() {
    }

    public QuestionOption(int questionOptionId, boolean trueFalse, String questionOption, Question question) {
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

    public void setQuestion(Question question) {
        this.question = question;
    }

    
}
