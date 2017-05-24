package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.User;
import com.mycompany.testverktygbackend.services.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users") //Vi behöver berätta att den här är sökvägen /user
@Produces(MediaType.APPLICATION_JSON)//Talar om att det finns metoder ska producera någonting, och vilken datatyp de har (kan också skrivas innan ensklida metoder)
@Consumes(MediaType.APPLICATION_JSON)//Detta gör att http kommer leta efter en post-metod
public class UserResources {

    UserService userService = new UserService();
     
    @POST //Producerar ett objekt (team - return) och konsumerar ett objekt (team - inargumentet)
    public User addUser(User user) {
        System.out.println("UserResource addUser");
        return userService.addUser(user);
    }
    
    @GET
    @Path("/{userId}")
    public User getUser(@PathParam("userId") int userId){    
        return userService.getUser(userId);
    }
    
    
    
}
