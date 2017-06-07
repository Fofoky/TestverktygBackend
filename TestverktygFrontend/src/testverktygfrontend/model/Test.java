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
    private StringProperty currentStatus;
    private StringProperty currentResult;

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
                if (startTime.length() == 10) {
                    startTime += "T00:00";

                } else {
                    startTime = startTime.replaceFirst(" ", "T");
                }
                
                LocalDateTime ldt = LocalDateTime.parse(startTime); // kontrollerar att det är rätt format
                
                this.startTime = new SimpleStringProperty(startTime);

            } catch (DateTimeParseException e) {
            }
        } else {
            this.startTime = new SimpleStringProperty("yyyy-mm-dd 00:00");
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
                if(endTime.length() == 10){
                    endTime += "T00:00";
                }else{
                    endTime = endTime.replaceFirst(" ", "T");
                }
                
                LocalDateTime end = LocalDateTime.parse(endTime); // kontrollerar att det är rätt format
                
                if(startTime != null && !startTime.equals("yyyy-mm-dd 00:00")){
                    LocalDateTime start = LocalDateTime.parse(startTime.get());
                    
                    if(end.compareTo(start) < 0){ // kollar att endTime ligger efter startTime
                       throw new NullPointerException();
                    }
                }
                this.endTime = new SimpleStringProperty(endTime);
            } catch (DateTimeParseException | NullPointerException e) {
            }

        } else {
            this.endTime = new SimpleStringProperty("yyyy-mm-dd 00:00");
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

    //Denna variabel sparas inte i databasen, behöver inte konverteras till primitiv datatyp
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = new SimpleStringProperty(currentStatus);
    }

    public String getCurrentStatus() {
        return currentStatus.get();
    }
    
    //Denna variabel sparas inte i databasen, behöver inte konverteras till primitiv datatyp
    public void setCurrentResult(String currentResult) {
        this.currentResult = new SimpleStringProperty(currentResult);
    }

    public String getCurrentResult() {
        return currentResult.get();
    }

}
