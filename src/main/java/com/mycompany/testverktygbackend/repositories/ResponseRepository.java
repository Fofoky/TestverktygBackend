/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Response;
import java.util.List;

import org.hibernate.Session;

/**
 *
 * @author rille
 */
public class ResponseRepository {
    
    Session session;

    public ResponseRepository() {
        session = HibernateUtil.getSession();
    }
    
    public List<Response> getAllResponses() {
        session.beginTransaction(); 
        List<Response> responses = session.createCriteria(Response.class).list(); 
        for(Response r: responses){
            r.getResponseId();
        }
        return responses; 
    }
    
    public Response addResponse(Response response){
        session.beginTransaction();
        session.save(response);
        session.getTransaction().commit();
        session.close();
        return response;
    
    }
}
