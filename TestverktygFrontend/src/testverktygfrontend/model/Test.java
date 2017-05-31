package testverktygfrontend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Richard
 */
public class Test implements Serializable {
    
    private int idTest; 
    private String title; 
    private Date startTime; 
    private Date endTime; 
    
    List<Question> questions; 
    
    Course course;
        
    
public Test(){
}

public Test(int idTest, String title, Date start, Date stop) {
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
    
    public String toString(){
        return title;
    }
    
}
