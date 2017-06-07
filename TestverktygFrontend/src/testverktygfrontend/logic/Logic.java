package testverktygfrontend.logic;

import java.util.List;
import testverktygfrontend.dbconnector.DBconnector;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.Response;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;
import testverktygfrontend.model.UserConverter;

public class Logic {

    private static Logic instance;
    private List<User> userList;
    private User selectedUser;
    private Course selectedCourse;
    private Test selectedTest;
    private Question selectedQuestion;

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
        
        try{
            selectedUser = getUser(selectedUser.getUserId());
            
            for(Course course : selectedUser.getCourses()){
                if(course.getCourseId() == selectedCourse.getCourseId()){
                    selectedCourse = course;
                }
            }
            for(Test test : selectedCourse.getTests()){
                if(test.getIdTest() == selectedTest.getIdTest()){
                    selectedTest = test;
                }
            }
            
        }catch(NullPointerException e){
            
        }
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
    
    public Question getSelectedQuestion(){
        return selectedQuestion;
    }
    
    public void setSelectedQuestion(Question selectedQuestion){
        this.selectedQuestion = selectedQuestion;
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

    public Question addQuestion(String question, int testId) {

        DBconnector db = new DBconnector();
        Question q = new Question();
        q.setQuestion(question);

        return db.addQuestion(q, testId, selectedUser.getUserId(), selectedCourse.getCourseId());

    }
    
    public Test addTest(Test test){
        DBconnector db = new DBconnector();
        test = db.addTest(test, selectedUser.getUserId(), selectedCourse.getCourseId());  
        setSelectedTest(test);
        
        return test;
    }
    
    public List<Test> getTests(int courseId, int userId){   
        DBconnector db = new DBconnector();
        System.out.println("Logic.getTest");
        return db.getTests(courseId, userId);
    }
     
    public void deleteQuestion(int questionId){
        DBconnector db = new DBconnector();
        db.deleteQuestion(questionId, selectedUser.getUserId(), selectedCourse.getCourseId(), selectedTest.getIdTest());
    }
    
    public void addQuestionOption(String questionOption, Boolean trueFalse, int questionId){
        DBconnector db = new DBconnector();
        QuestionOption qOption = new QuestionOption();
        qOption.setQuestionOption(questionOption);
        qOption.setTrueFalse(trueFalse);
        
        db.addQuestionOption(qOption, selectedUser.getUserId(), selectedCourse.getCourseId(), selectedTest.getIdTest(), questionId);
    } 
    
    // Farhads code starts here
    
    public Response addResponse(QuestionOption q, int userId, int questionId){
        DBconnector db = new DBconnector();
        
        return db.addResponse(q, userId, selectedCourse.getCourseId(), selectedTest.getIdTest(), questionId);
    }
    
    public void updateQuestionOption(String newQuestionOption, int questionOptionId, int questionId){
        DBconnector db = new DBconnector();
        QuestionOption qO = new QuestionOption();
        qO.setQuestionOption(newQuestionOption);
        db.updateQuestionOption(qO, selectedUser.getUserId(), selectedCourse.getCourseId(), selectedTest.getIdTest(), questionId, questionOptionId);
        
    }
    
    //Farhads code starts here
    
    public void updateQuestion(String question, int questionId) {

            DBconnector db = new DBconnector();
            Question que = new Question();
            que.setQuestion(question);
            db.updateQuestion(que, questionId, selectedTest.getIdTest(), selectedUser.getUserId(), selectedCourse.getCourseId());
    }

    public void deleteTest(int testId) {
        DBconnector db = new DBconnector();
        db.deleteTest(testId, selectedUser.getUserId(), selectedCourse.getCourseId());
        
    }

    public void updateTest(Test test) {
        DBconnector db = new DBconnector();
        db.updateTest(test, selectedUser.getUserId(), selectedCourse.getCourseId());
    }

}
