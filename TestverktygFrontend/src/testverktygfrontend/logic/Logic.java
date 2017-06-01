package testverktygfrontend.logic;

import java.util.List;
import testverktygfrontend.dbconnector.DBconnector;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;
import testverktygfrontend.model.UserConverter;

public class Logic {

    private static Logic instance;
    private List<User> userList = null;
    private User selectedUser;
    private Course selectedCourse;
    private Test selectedTest;

    private Logic() {
    }

    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }

    public void updateList() {
        DBconnector db = new DBconnector();
        userList = db.getUsers();
    }

    public List<User> getUsers() {
        return userList;
    }

    public User getUser(int userId) {
        User user = null;
        for (User u : userList) {
            if (u.getUserId() == userId) {
                user = u;
            }
        }
        return user;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public Test getSelectedTest() {
        return selectedTest;
    }

    public void setSelectedTest(Test selectedTest) {
        this.selectedTest = selectedTest;
    }

    public void addUser(String name, String userRole, String password, String email) {
        DBconnector db = new DBconnector();
        UserConverter user = new UserConverter();
        user.setName(name);
        user.setUserRole(userRole);
        user.setPassword(password);
        user.setEmail(email);
        db.addUser(user);
    }

    public void addQuestion(String question, int testId, int courseId) {

        DBconnector db = new DBconnector();

        Question q = new Question();

        q.setQuestion(question);

        db.addQuestion(q, testId, selectedUser.getUserId(), courseId);

    }
    
    public void addTest(Test test, int courseId){
        DBconnector db = new DBconnector();
        db.addTest(test, selectedUser.getUserId(), courseId);  
    }
    
        
    public void updateQuestion(String question, int questionId, int testId, int courseId ) {

            DBconnector db = new DBconnector();
            Question que = new Question();
            
            que.setQuestionId(questionId);
            que.setQuestion(question);
            
            db.updateQuestion(que, questionId, testId, selectedUser.getUserId(), courseId);
    }
}
