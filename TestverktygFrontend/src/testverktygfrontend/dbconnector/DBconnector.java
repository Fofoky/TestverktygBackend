package testverktygfrontend.dbconnector;

// @author Anton
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.Response;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;
import testverktygfrontend.model.UserConverter;

public class DBconnector {

    Client client;

     //private String url = "http://localhost:8080/testverktygbackend/webapi/users/"; 
   private String url = "http://localhost:8080/TestverktygBackend/webapi/users/"; // Annas URL

    public DBconnector() {
        client = ClientBuilder.newClient();
    }

    public List<User> getUsers() {
        ArrayList<User> users = new ArrayList();
        
        List<UserConverter> userConverter = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<UserConverter>>() {
                });
        
        for (UserConverter user : userConverter) {

            users.add(userConverterToUser(user));
        }

        for (User user : users) {
            user.setCourses(getCourse(user.getUserId()));
        }
        
        return users;
    }

    private List<Course> getCourse(int userId) {
        String target = url + userId + "/courses";
        List<Course> userCourses = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Course>>() {
                });

        for (Course course : userCourses) {
            course.setTests(getTests(course.getCourseId(), userId));
        }

        return userCourses;
    }

    private List<Test> getTests(int courseId, int userId) {
        String target = url + userId + "/courses/" + courseId + "/tests";
        List<Test> tests = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Test>>() {
                });

        for (Test test : tests) {
            test.setQuestions(getQuestions(userId, courseId, test.getIdTest()));
        }

        return tests;
    }

    private List<Question> getQuestions(int userId, int courseId, int testId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions";
        List<Question> questions = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Question>>() {
                });

        for (Question question : questions) {
            question.setQuestionOptions(getOptions(userId, courseId, testId, question.getQuestionId()));
            question.setResponses(getResponses(userId, courseId, testId, question.getQuestionId()));
        }

        return questions;
    }

    private List<QuestionOption> getOptions(int userId, int courseId, int testId, int questionId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/questionoption";
        List<QuestionOption> options = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<QuestionOption>>() {
                });

        return options;
    }

    private List<Response> getResponses(int userId, int courseId, int testId, int questionId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/responses";
        List<Response> responses = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Response>>() {
                });
        return responses;
    }

    public void addUser(UserConverter user) {
        String target = url;

        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(user), User.class);
    }

    public void addQuestion(Question question, int testId, int userId, int courseId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions";

        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(question), Question.class);
    }
    
    public void addTest(Test test, int userId, int courseId) {
        String target = url + userId + "/courses/" + courseId + "/tests";
        
        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(test), Test.class);
        
    }
    
    public void deleteQuestion(int questionId, int userId, int courseId, int testId){
       String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId;
       
       client.target(target)
               .request(MediaType.APPLICATION_JSON)
               .delete();
    }
    
    public QuestionOption addQuestionOption(QuestionOption qOption, int userId, int courseId, int testId, int questionId){
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/questionoption";
        
        QuestionOption qO = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(qOption), QuestionOption.class);
        
        return qO;
    }

    private UserConverter userToUserConverter(User oldUser) {
        UserConverter newUser = new UserConverter();

        newUser.setUserId(oldUser.getUserId());
        newUser.setName(oldUser.getName());
        newUser.setCourses(oldUser.getCourses());
        newUser.setEmail(oldUser.getEmail());
        newUser.setPassword(oldUser.getPassword());
        newUser.setUserRole(oldUser.getUserRole());

        return newUser;
    }

    private User userConverterToUser(UserConverter oldUser) {
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
