package testverktygfrontend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Richard
 */
public class Test implements Serializable {

    private IntegerProperty idTest;
    private StringProperty title;
    private StringProperty startTime;
    private StringProperty endTime;

    List<Question> questions;

    Course course;

    public Test() {
    }

    public Test(int idTest, String title, String start, String stop) {
        this.idTest = new SimpleIntegerProperty(idTest);
        this.title = new SimpleStringProperty(title);
        this.startTime = new SimpleStringProperty(start);
        this.endTime = new SimpleStringProperty(stop);
        this.questions = new ArrayList();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getIdTest() {
        return idTest.get();
    }

    public void setIdTest(int idTest) {
        this.idTest = new SimpleIntegerProperty(idTest);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title = new SimpleStringProperty(title);
    }

    public String getStartTime() {
        try {
            return startTime.get();
        } catch (NullPointerException e) {
            return " ";
        }

    }

    public void setStartTime(String startTime) {
        if (startTime != null) {
            try {
                LocalDateTime ld = LocalDateTime.parse(startTime); // kontrollerar att det är rätt format
                this.startTime = new SimpleStringProperty(startTime);
            } catch (DateTimeParseException e) {
            }
        } else {
            this.startTime = new SimpleStringProperty(" ");
        }
    }

    public String getEndTime() {
        try {
            return endTime.get();
        } catch (NullPointerException e) {
            return " ";
        }
    }

    public void setEndTime(String endTime) {
        if (endTime != null) {
            try {
                LocalDateTime ld = LocalDateTime.parse(endTime); // kontrollerar att det är rätt format
                this.endTime = new SimpleStringProperty(endTime);
            } catch (DateTimeParseException e) {
            }

        } else {
            this.endTime = new SimpleStringProperty(" ");
        }
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}
