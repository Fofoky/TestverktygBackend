package testverktygfrontend.model;

// @author Anton

import java.io.Serializable;
import java.util.List;

 
public class UserConverter implements Serializable {

    private int userId;
    private String Name;
    private String userRole;
    private String password;
    private String email;

    private List<Course> courses;

    public UserConverter() {
    }

    public UserConverter(int userId, String Name, String userRole, String password, String email) {
        this.userId = userId;
        this.Name = Name;
        this.userRole = userRole;
        this.password = password;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
