package testverktygfrontend.dbconnector;

// @author Anton

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;
import testverktygfrontend.model.UserConverter;

 
public class DBconnector {
    
    Client client;
    
    public DBconnector(){
        client = ClientBuilder.newClient();
    }
    
    public List<User> getUsers(){
        List<UserConverter> userConverter = client.target("http://localhost:8080/testverktygbackend/webapi/users")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<UserConverter>>(){});
        
        ArrayList<User> users = new ArrayList();
        
        for(UserConverter user : userConverter){
            
            users.add(userConverterToUser(user));
        }
        
        for(User user : users){
            user.setCourses(getCourse(user.getUserId()));
        }
        
        return users;
    }
    
    public List<Course> getCourse(int userId){
        String target = "http://localhost:8080/testverktygbackend/webapi/users/" + userId + "/courses";
        List<Course> userCourses = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Course>>(){});
        
        for(Course course : userCourses){
            course.setTests(getTests(course.getCourseId(), userId));
        }
        
        return userCourses;
    }
    
    public List<Test> getTests(int courseId, int userId){
        String target = "http://localhost:8080/testverktygbackend/webapi/users/" + userId + "/courses/" + courseId + "/tests";
        List<Test> tests = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Test>>(){});
        
        for(Test test : tests){
            test.setQuestions(getQuestions(userId, courseId, test.getTestId()));
        }
        
        
        return tests;
    }
    
    public List<Question> getQuestions(int userId, int courseId, int testId){
        String target = "http://localhost:8080/testverktygbackend/webapi/users/" + userId + "/courses/" + courseId + "/tests/" + testId + "/questions";
        List<Question> questions = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Question>>(){});
        
        return questions;
    }
    
    
    
    
    
     public UserConverter userToUserConverter(User oldUser){
        UserConverter newUser = new UserConverter();
        
        newUser.setUserId(oldUser.getUserId());
        newUser.setName(oldUser.getName());
        newUser.setCourses(oldUser.getCourses());
        newUser.setEmail(oldUser.getEmail());
        newUser.setPassword(oldUser.getPassword());
        newUser.setUserRole(oldUser.getUserRole());
        
        return newUser; 
    }
     
     public User userConverterToUser(UserConverter oldUser){
         User newUser = new User();
         
        newUser.setUserId(oldUser.getUserId());
        newUser.setName(oldUser.getName());
        newUser.setCourses(oldUser.getCourses());
        newUser.setEmail(oldUser.getEmail());
        newUser.setPassword(oldUser.getPassword());
        newUser.setUserRole(oldUser.getUserRole());
        
        return newUser; 
     }
    

}
