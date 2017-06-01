package testverktygfrontend.model;

// @author Anton

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

 
public class User implements Serializable {

    private IntegerProperty userId;
    private StringProperty name;
    private StringProperty userRole;
    private StringProperty password;
    private StringProperty email;
    private StringProperty currentResult;

    private List<Course> courses;

    public User() {
    }

    public User(int userId, String Name, String userRole, String password, String email) {
        this.userId.set(userId);
        this.name.set(Name);
        this.userRole.set(userRole);
        this.password.set(password);
        this.email.set(email);
    }

    public int getUserId() {
        return userId.get();
    }

    public void setUserId(int userId) {
        this.userId = new SimpleIntegerProperty(userId);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String Name) {
        this.name = new SimpleStringProperty(Name);
    }

    public String getUserRole() {
        return userRole.get();
    }

    public void setUserRole(String userRole) {
        this.userRole = new SimpleStringProperty(userRole);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setCurrentResult(String currentResult) {
        this.currentResult = new SimpleStringProperty(currentResult);
    }
    
    public String getCurrentResult(){
        return currentResult.get();
    }

}
