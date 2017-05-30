package testverktygfrontend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Richard
 */
public class Test implements Serializable {
    
    private int testId;
    private String title;
    private Date startTime;
    private Date endTime;
    
    private List<Question> questions;
    private Course course;
    
    public Test(){}
    
    public Test(int testId, String title, Date startTime, Date endTime){
        this.testId = testId;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
