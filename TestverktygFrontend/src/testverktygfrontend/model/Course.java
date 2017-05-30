package testverktygfrontend.model;

import java.io.Serializable;
import java.util.List;


public class Course implements Serializable {
    
    private int courseId;
    private String name;
    private List<User> users;
    private List<Test> tests;
    
    public Course(){}
    
    public Course(int courseId, String name){
        this.courseId = courseId;
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
  
}
