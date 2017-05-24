/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Test;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ULTRA
 */
public class TestRepository {
    
    public List<Test> getAllTest(){
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Test> tests = session.createCriteria(Test.class).list(); 
            for(Test t: tests){
                t.getQuestions().size();
            }
         return tests;
        
        
//        List<Drivers> drivers = session.createCriteria(Drivers.class).list();
//        for(Drivers d : drivers){
//            d.getRaces().size();
//        }
//        return drivers;
        
    }
    
}
