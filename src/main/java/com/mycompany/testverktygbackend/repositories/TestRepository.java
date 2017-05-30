package com.mycompany.testverktygbackend.repositories;

import com.mycompany.testverktygbackend.models.Test;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ULTRA
 */
public class TestRepository {

    Session session;

    public TestRepository() {
        session = HibernateUtil.getSession();
    }

    public List<Test> getAllTest() {
        
        session.beginTransaction();
        List<Test> tests = session.createCriteria(Test.class).list();
        for (Test t : tests) {
            t.getQuestions().size();
        }
        return tests;
    }

    public Test addTest(Test test) {
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        session.close();
        return test;
    }

    public Test getTest(int testId) {
        Test test = (Test) session.get(Test.class, testId);
        return test;
    }

}
