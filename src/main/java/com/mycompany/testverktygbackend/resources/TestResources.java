/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.services.TestServices;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ULTRA
 */
@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)    

public class TestResources {
    
        TestServices ts = new TestServices();
        
@GET
public List<Test> getAllTest() {
    return ts.getAllTests();
}



}
