package testverktygfrontend.model;

// @author Anton

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

 
public class TemporaryQuestionCreate {
    
    private IntegerProperty id;
    private StringProperty question;
    private StringProperty option1;
    private StringProperty option2;
    private StringProperty option3;
    private StringProperty option4;
    
    public TemporaryQuestionCreate(){}

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question = new SimpleStringProperty(question);
    }

    public String getOption1() {
        return option1.get();
    }

    public void setOption1(String option) {
        this.option1 = new SimpleStringProperty(option);
    }

    public String getOption2() {
        return option2.get();
    }
    
    public void setOption2(String option) {
        this.option2 = new SimpleStringProperty(option);
    }
    
    public String getOption3() {
        return option3.get();
    }
    
    public void setOption3(String option) {
        this.option3 = new SimpleStringProperty(option);
    }
    
    public String getOption4() {
        return option4.get();
    }
    
    public void setOption4(String option) {
        this.option4 = new SimpleStringProperty(option);
    }


    
}
