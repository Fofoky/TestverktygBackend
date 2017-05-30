/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend.model;

import java.io.Serializable;

public class Response implements Serializable{
    
    private int responseId;
    private String response;
    private int userId;
    
    private Question question;
    
    public Response(){}
    
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
