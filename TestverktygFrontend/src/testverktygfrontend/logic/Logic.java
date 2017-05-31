package testverktygfrontend.logic;

import java.util.List;
import testverktygfrontend.dbconnector.DBconnector;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.User;
import testverktygfrontend.model.UserConverter;

public class Logic {

    private static Logic instance;
    private List<User> userList = null;
    private User currentUser;
    DBconnector db = new DBconnector();

    private Logic() {}

    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }

    public void updateList() {
        userList = db.getUsers();
    }

    public List<User> getUsers() {
        return userList;
    }

    public void addQuestion(String question, int testId, int userId, int courseId) {
        Question q = new Question();
        q.setQuestion(question);
        
        db.addQuestion(q, testId, userId, courseId);
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

    public User getCurrentUser() {
        return currentUser;
    } // Getter & Setter för inloggad User

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public void addUser(String name, String userRole, String password, String email){
        UserConverter user = new UserConverter();
        user.setName(name);
        user.setUserRole(userRole);
        user.setPassword(password);
        user.setEmail(email);
        
        db.addUser(user);
    }
}
