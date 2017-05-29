package com.mycompany.testverktygbackend.resources;

import com.mycompany.testverktygbackend.models.User;
import com.mycompany.testverktygbackend.services.*;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users") //Vi behöver berätta att den här är sökvägen /user
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {

    UserService userService = new UserService();
    
    @GET
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @POST //Producerar ett objekt (team - return) och konsumerar ett objekt (team - inargumentet)
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @GET
    @Path("/{userId}")
    public User getUser(@PathParam("userId") int userId) {
        return userService.getUser(userId);
    }
    
    

    @Path("/{userId}/courses")
    public CourseResource course() {
        return new CourseResource();
    }

}
