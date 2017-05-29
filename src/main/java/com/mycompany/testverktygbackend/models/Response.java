package com.mycompany.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Response implements Serializable{
    
    @Id
    @GeneratedValue
    private int responseId;
    private String response;
    private int userId;
    
    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    private Question question;
    
    public Response(){
    }
    
    public Response(int responseId, String response, int userId){
        this.responseId = responseId;
        this.response = response;
        this.userId = userId;
    }
    
    

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    
 
}
