package com.mycompany.testverktygbackend.repositories;

// @author Anton
import com.mycompany.testverktygbackend.models.QuestionOption;
import org.hibernate.Session;

public class QuestionOptionRepository {

    Session session;

    public QuestionOptionRepository() {
        session = HibernateUtil.getSession();
    }

    public QuestionOption addQuestionOption(QuestionOption option) {
        session.beginTransaction();
        session.save(option);
        session.getTransaction().commit();
        session.close();
        return option;
    }

}
