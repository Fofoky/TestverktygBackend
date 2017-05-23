/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author ULTRA
 */
@Entity 
public class Test implements Serializable {
    
   
    @Id@GeneratedValue
    private int idTest; 
    private String title; 
    private Date start; 
    private Date stop; 
    List<Questions> questions; 
    
    
public Test(){
}

public Test(int idTest, String title, Date start, Date stop) {
    this.idTest = idTest; 
    this.title = title; 
    this.start = start; 
    this.stop = stop; 
    this.questions = new ArrayList(); 
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }



}
