package com.mycompany.testverktygbackend.repositories;

// @author Anton
import com.mycompany.testverktygbackend.models.QuestionOption;
import java.util.List;
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
    
    public List<QuestionOption> getQuestionOptions(){
        session.beginTransaction(); 
        List<QuestionOption> qaoptions = session.createCriteria(QuestionOption.class).list(); 
        for (QuestionOption qa: qaoptions){
            qa.getQuestion().getQuestionOptions().size();
        }
        return qaoptions;
    }

}
