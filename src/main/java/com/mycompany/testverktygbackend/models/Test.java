package com.mycompany.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity 
public class Test implements Serializable {
      
    @Id@GeneratedValue
    private int idTest; 
    private String title; 
    private String startTime; 
    private String endTime; 
    
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    @JsonManagedReference  
    List<Question> questions; 
    
    @ManyToOne
    @JsonBackReference
    Course course;
        
    
public Test(){
}

public Test(int idTest, String title, String start, String stop) {
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
        try{
            LocalDateTime ld = LocalDateTime.parse(startTime); // kontrollerar att det är rätt format
            this.startTime = startTime;
        }catch(DateTimeParseException e){}
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
         try{
            LocalDateTime ld = LocalDateTime.parse(endTime); // kontrollerar att det är rätt format
            this.endTime = endTime;
        }catch(DateTimeParseException e){}
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
   
}
