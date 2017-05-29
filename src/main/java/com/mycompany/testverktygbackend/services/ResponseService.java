/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Response;
import com.mycompany.testverktygbackend.repositories.ResponseRepository;
import java.util.List;

/**
 *
 * @author rille
 */
public class ResponseService {
    
    ResponseRepository rr = new ResponseRepository();

    public List<Response> getAllResponses() {
        return rr.getAllResponses();
    }

    public Response addResponse(Response response) {
        return rr.addResponse(response);
    }
    
}
