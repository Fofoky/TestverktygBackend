/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.repositories.TestRepository;
import java.util.List;

/**
 *
 * @author ULTRA
 */
public class TestServices {
    
    TestRepository tr = new TestRepository();

    public List<Test> getAllTests() {
        return tr.getAllTest();
    }
    
}
