package com.mycompany.testverktygbackend.models;

// @author Anton
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String option;

    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    Question question;

    public QuestionOption() {
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

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
}
