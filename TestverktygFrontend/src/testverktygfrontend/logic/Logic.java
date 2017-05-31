package testverktygfrontend.logic;

import java.util.List;
import testverktygfrontend.dbconnector.DBconnector;
import testverktygfrontend.model.User;

public class Logic {
    
    private static Logic instance;
    private List<User> userList = null;
    private User currentUser;
    
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

    public User getCurrentUser() {
        return currentUser;
    } // Getter & Setter för inloggad User

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
   
    
}
