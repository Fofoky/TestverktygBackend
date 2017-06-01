package testverktygfrontend.model;

// @author Anton

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 
public class TestConverter implements Serializable {
    
    private int idTest; 
    private String title; 
    private String startTime; 
    private String endTime; 
    
    List<Question> questions; 
    
    Course course;
        
    
public TestConverter(){
}

public TestConverter(int idTest, String title, String start, String stop) {
    this.idTest = idTest; 
    this.title = title; 
    this.startTime = start; 
    this.endTime = stop; 
    this.questions = new ArrayList(); 
} 

    public List<Question> getQuestions() {
        return questions;
    }
    


    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
