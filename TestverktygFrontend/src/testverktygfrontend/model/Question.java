package testverktygfrontend.model;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Richard
 */
public class Question implements Serializable {
    
    private IntegerProperty questionId;
    private StringProperty question;
    
    private Test test;
    private List<Response> responses;
    private List<QuestionOption> questionOptions;
    
    
    public Question(){}
    
    public Question(int questionId, String question){
        this.questionId = new SimpleIntegerProperty(questionId);
        this.question = new SimpleStringProperty(question);
    }

    public int getQuestionId() {
        return questionId.get();
    }

    public void setQuestionId(int questionId) {
        this.questionId = new SimpleIntegerProperty(questionId);
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question = new SimpleStringProperty(question);
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }
    
}
