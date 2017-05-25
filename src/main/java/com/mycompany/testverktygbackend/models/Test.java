/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


@Entity 
public class Test implements Serializable {
      
    @Id@GeneratedValue
    private int idTest; 
    private String title; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime; 
    
    @OneToMany(mappedBy = "test")
    @JsonManagedReference  
    List<Question> questions = new ArrayList<>(); 
    
    @ManyToOne
    @JsonBackReference
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
    
    



}
