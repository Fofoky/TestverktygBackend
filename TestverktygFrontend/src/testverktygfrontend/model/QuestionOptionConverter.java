package testverktygfrontend.model;

// @author Anton

import java.io.Serializable;

 
public class QuestionOptionConverter implements Serializable{
    
    private int questionOptionId;
    private boolean trueFalse;
    private String questionOption;
    
    private Question question;
    
    public QuestionOptionConverter(){}
    
    public QuestionOptionConverter(int questionOptionId, boolean trueFalse, String questionOption){
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
