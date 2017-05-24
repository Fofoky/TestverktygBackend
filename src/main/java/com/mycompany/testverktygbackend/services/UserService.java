/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.User;
import com.mycompany.testverktygbackend.repositories.*;


public class UserService {
    UserRepository userRepository = new UserRepository();
    
    public User addUser(User user){
        userRepository.addUser(user);
        
        return user;
    }
    
    public User getUser(int userId){
        return userRepository.getUser(userId);
    }
}
