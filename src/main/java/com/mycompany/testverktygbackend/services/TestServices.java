package com.mycompany.testverktygbackend.services;

import com.mycompany.testverktygbackend.models.Test;
import com.mycompany.testverktygbackend.repositories.TestRepository;
import java.util.List;
public class TestServices {

    public Test addTest(Test test) {
       TestRepository db = new TestRepository();
       return db.addTest(test);
    }
    
    TestRepository tr = new TestRepository();

    public List<Test> getAllTests() {
        return tr.getAllTest();
    }
    
}
