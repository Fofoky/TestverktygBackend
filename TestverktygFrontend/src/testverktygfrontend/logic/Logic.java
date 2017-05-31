package testverktygfrontend.logic;

import java.util.List;
import testverktygfrontend.dbconnector.DBconnector;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;

public class Logic {
    
    private static Logic instance;
    private List<User> userList = null;
    private User selectedUser;
    private Course selectedCourse;
    private Test selectedTest;
    
    private Logic(){}
    
    public static Logic getInstance(){
        if(instance == null){
            instance = new Logic();
        }
        return instance;
    }
    
    public void updateList(){
        DBconnector db = new DBconnector();
        userList = db.getUsers();
    }
    
    public List<User> getUsers(){
        return userList;
    }
    
    public User getUser(int userId){
        User user = null;
        for(User u : userList){
            if(u.getUserId() == userId){
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
    
    
    
    
    
    
    
}
