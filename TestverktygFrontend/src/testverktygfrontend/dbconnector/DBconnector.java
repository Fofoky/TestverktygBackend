package testverktygfrontend.dbconnector;

// @author Anton

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

 
public class DBconnector {
    
    Client client;
    
    public DBconnector(){
        client = ClientBuilder.newClient();
    }
    
    public List<User> getUsers(){
        List<User> users = client.target("http://localhost:8080/testverktygbackend/webapi/users")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<User>>(){});
        
        for(User user : users){
            user.setCourses(getCourse(user.getId()));
        }
        
        return users;
    }
    
    public List<Course> getCourse(int userId){
        String target = "http://localhost:8080/testverktygbackend/webapi/users/" + userId + "/courses";
        List<Course> userCourses = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Course>>(){});
        
        for(Course course : userCourses){
            course.setTests(getTests(course.getId(), userId));
        }
        
        return userCourses;
    }
    
    public List<Test> getTests(int courseId, int userId){
        String target = "http://localhost:8080/testverktygbackend/webapi/users/" + userId + "/courses/" + courseId + "/tests";
        List<Test> tests = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Test>>(){});
        
        
        
        return tests;
    }
    
    
    
    
    
    

}
