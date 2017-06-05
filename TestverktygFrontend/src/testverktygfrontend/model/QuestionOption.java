package testverktygfrontend.model;

import java.io.Serializable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Richard
 */
public class QuestionOption implements Serializable{
    
    private IntegerProperty questionOptionId;
    private BooleanProperty trueFalse;
    private StringProperty questionOption;
    
    private Question question;
    
    public QuestionOption(){}
    
    public QuestionOption(int questionOptionId, boolean trueFalse, String questionOption){
        this.questionOptionId = new SimpleIntegerProperty(questionOptionId);
        this.trueFalse = new SimpleBooleanProperty(trueFalse);
        this.questionOption = new SimpleStringProperty(questionOption);
    }
    
    public QuestionOption(String questionOption, boolean trueFalse, Question question){
        this.questionOption = new SimpleStringProperty(questionOption);
        this.trueFalse = new SimpleBooleanProperty(trueFalse);
        this.question = question;
    }

    public int getQuestionOptionId() {
        return questionOptionId.get();
    }

    public void setQuestionOptionId(int questionOptionId) {
        this.questionOptionId = new SimpleIntegerProperty(questionOptionId);
    }

    public boolean isTrueFalse() {
        return trueFalse.get();
    }

    public void setTrueFalse(boolean trueFalse) {
        this.trueFalse = new SimpleBooleanProperty(trueFalse);
    }

    public String getQuestionOption() {
        return questionOption.get();
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = new SimpleStringProperty(questionOption);
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
}
