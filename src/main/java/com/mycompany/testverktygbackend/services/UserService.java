package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.User;
import com.mycompany.testverktygbackend.repositories.*;
import java.util.List;


public class UserService {
    UserRepository userRepository = new UserRepository();
    
    public User addUser(User user){
        userRepository.addUser(user);
        
        return user;
    }
    
    public User getUser(int userId){
        return userRepository.getUser(userId);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
