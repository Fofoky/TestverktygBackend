/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 * @author rille
 */
public class Response {
    @Id@GeneratedValue
    private int responseId;
    private String response;
    private int userId;
    
    public Response(int responseId, String response, int userId){
        this.responseId = responseId;
        this.response = response;
        this.userId = userId;
    }
    
    public Response(){}

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
    
    
    
    
}
