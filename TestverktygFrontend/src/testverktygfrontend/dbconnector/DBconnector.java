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
import testverktygfrontend.model.QuestionConverter;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.QuestionOptionConverter;
import testverktygfrontend.model.Response;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.TestConverter;
import testverktygfrontend.model.User;
import testverktygfrontend.model.UserConverter;

public class DBconnector {

    Client client;

    private String url = "http://localhost:8080/testverktygbackend/webapi/users/";
    // private String url = "http://localhost:8080/TestverktygBackend/webapi/users/"; // Annas URL

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

        ArrayList<Test> tests = new ArrayList();

        List<TestConverter> testsConverter = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<TestConverter>>() {
                });

        for (TestConverter tc : testsConverter) {

            tests.add(testConverterToTest(tc));
        }

        for (Test test : tests) {
            test.setQuestions(getQuestions(userId, courseId, test.getIdTest()));
        }

        return tests;
    }

    private List<Question> getQuestions(int userId, int courseId, int testId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions";
        ArrayList<Question> questions = new ArrayList();

        List<QuestionConverter> questionConverts = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<QuestionConverter>>() {
                });

        for (QuestionConverter qu : questionConverts) {
            questions.add(questionConverterToQuestion(qu));
        }

        for (Question question : questions) {
            question.setQuestionOptions(getOptions(userId, courseId, testId, question.getQuestionId()));
            question.setResponses(getResponses(userId, courseId, testId, question.getQuestionId()));
        }

        return questions;
    }

    private List<QuestionOption> getOptions(int userId, int courseId, int testId, int questionId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/questionoption";

        ArrayList<QuestionOption> options = new ArrayList();

        List<QuestionOptionConverter> optionsConvert = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<QuestionOptionConverter>>() {
                });

        for (QuestionOptionConverter oc : optionsConvert) {
            options.add(optionConverterToOption(oc));
        }

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

    public Question addQuestion(Question oldQuestion, int testId, int userId, int courseId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions";

        QuestionConverter newQuestion = questionToQuestionConverter(oldQuestion);

        newQuestion = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newQuestion), QuestionConverter.class);

        return questionConverterToQuestion(newQuestion);
    }

    public Test addTest(Test test, int userId, int courseId) {
        String target = url + userId + "/courses/" + courseId + "/tests";
        TestConverter newTest = testToTestConverter(test);

        newTest = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newTest), TestConverter.class);

        return testConverterToTest(newTest);

    }
    
    public void deleteTest(int testId, int userId, int courseId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId;
        
        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .delete();
        
    }

    public void deleteQuestion(int questionId, int userId, int courseId, int testId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId;

        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }

    public void addQuestionOption(QuestionOption oldOption, int userId, int courseId, int testId, int questionId) {

        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/questionoption";

        QuestionOptionConverter newOption = optionToOptionConverter(oldOption);

        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(newOption), QuestionOptionConverter.class);
    }

    // Farhads code starts here  
    public Response addResponse(Response response, int userId, int courseId, int testId, int questionId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/responses";
        Response r = client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(response), Response.class);

        return r;
    }

    public void updateQuestionOption(QuestionOption qO, int userId, int courseId, int testId, int questionId, int questionOptionId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId + "/questionoption/" + questionOptionId;

        client.target(target)
                .request()
                .put(Entity.entity(optionToOptionConverter(qO), MediaType.APPLICATION_JSON));
    }

    // Farhad code starts here
    public void updateQuestion(Question question, int questionId, int testId, int userId, int courseId) {
        String target = url + userId + "/courses/" + courseId + "/tests/" + testId + "/questions/" + questionId;

        client.target(target)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(question, MediaType.APPLICATION_JSON));
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

    private Test testConverterToTest(TestConverter oldTest) {
        Test newTest = new Test();

        newTest.setIdTest(oldTest.getIdTest());
        newTest.setTitle(oldTest.getTitle());
        newTest.setCourse(oldTest.getCourse());
        newTest.setEndTime(oldTest.getEndTime());
        newTest.setStartTime(oldTest.getStartTime());

        return newTest;
    }

    private TestConverter testToTestConverter(Test oldTest) {
        TestConverter newTest = new TestConverter();
        try {
            newTest.setTitle(oldTest.getTitle());
        } catch (NullPointerException e) {
        }
        try {
            newTest.setIdTest(oldTest.getIdTest());
        } catch (NullPointerException e) {
        }
        try {
            newTest.setCourse(oldTest.getCourse());
        } catch (NullPointerException e) {
        }
        try {
            newTest.setEndTime(oldTest.getEndTime());
        } catch (NullPointerException e) {
        }
        try {
            newTest.setStartTime(oldTest.getStartTime());
        } catch (NullPointerException e) {
        }
        return newTest;
    }

    private Question questionConverterToQuestion(QuestionConverter oldQuestion) {
        Question newQuestion = new Question();

        newQuestion.setQuestion(oldQuestion.getQuestion());
        newQuestion.setQuestionId(oldQuestion.getQuestionId());
        newQuestion.setTest(oldQuestion.getTest());

        return newQuestion;
    }

    private QuestionConverter questionToQuestionConverter(Question oldQuestion) {
        QuestionConverter newQuestion = new QuestionConverter();
        try {
            newQuestion.setQuestion(oldQuestion.getQuestion());
        } catch (NullPointerException e) {
        }
        try {
            newQuestion.setQuestionId(oldQuestion.getQuestionId());
        } catch (NullPointerException e) {
        }
        try {
            newQuestion.setTest(oldQuestion.getTest());
        } catch (NullPointerException e) {
        }

        return newQuestion;
    }

    private QuestionOption optionConverterToOption(QuestionOptionConverter oldOption) {
        QuestionOption newOption = new QuestionOption();

        newOption.setQuestion(oldOption.getQuestion());
        newOption.setQuestionOption(oldOption.getQuestionOption());
        newOption.setQuestionOptionId(oldOption.getQuestionOptionId());
        newOption.setTrueFalse(oldOption.isTrueFalse());

        return newOption;
    }

    private QuestionOptionConverter optionToOptionConverter(QuestionOption oldOption) {
        QuestionOptionConverter newOption = new QuestionOptionConverter();
        try {
            newOption.setQuestion(oldOption.getQuestion());
        } catch (NullPointerException e) {
        }
        try {
            newOption.setQuestionOption(oldOption.getQuestionOption());
        } catch (NullPointerException e) {
        }
        try {
            newOption.setQuestionOptionId(oldOption.getQuestionOptionId());
        } catch (NullPointerException e) {
        }
        try {
            newOption.setTrueFalse(oldOption.isTrueFalse());
        } catch (NullPointerException e) {
        }
        return newOption;
    }
    
}
