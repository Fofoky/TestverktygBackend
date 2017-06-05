package testverktygfrontend.model;

// @author Anton

import java.io.Serializable;
import java.util.List;

 
public class QuestionConverter implements Serializable {
    
    private int questionId;
    private String question;
    
    private Test test;
    private List<Response> responses;
    private List<QuestionOption> questionOptions;
    
    
    public QuestionConverter(){}
    
    public QuestionConverter(int questionId, String question){
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

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
    
    public void setResponse(Response response){
        responses.add(response);
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }
    
}
