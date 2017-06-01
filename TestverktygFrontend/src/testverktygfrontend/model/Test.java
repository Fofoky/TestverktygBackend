package testverktygfrontend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Richard
 */
public class Test implements Serializable {
    
    private IntegerProperty idTest; 
    private StringProperty title; 
    private Date startTime; 
    private Date endTime; 
    
    List<Question> questions; 
    
    Course course;
        
    
public Test(){
}

public Test(int idTest, String title, Date start, Date stop) {
    this.idTest = new SimpleIntegerProperty(idTest); 
    this.title = new SimpleStringProperty(title); 
    this.startTime = start; 
    this.endTime = stop; 
    this.questions = new ArrayList(); 
} 

    public List<Question> getQuestions() {
        return questions;
    }
    


    public int getIdTest() {
        return idTest.get();
    }

    public void setIdTest(int idTest) {
        this.idTest = new SimpleIntegerProperty(idTest);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
    
    
    
}
