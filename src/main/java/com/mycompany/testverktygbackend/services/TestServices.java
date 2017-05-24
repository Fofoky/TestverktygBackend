package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.repositories.TestRepository;


public class TestServices {

    public Test addTest(Test test) {
       TestRepository db = new TestRepository();
       return db.addTest(test);
    }
    
}
