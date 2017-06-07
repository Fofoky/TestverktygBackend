package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.Response;
import testverktygfrontend.model.Test;

public class StudSelectedCourseController implements Initializable {

    private Logic logic;
    private Course selectedCourse;
    private ObservableList<Test> testList;

    @FXML
    private Label labelCourse;

    @FXML
    private TableView<Test> tableTests;

    @FXML
    private TableColumn<Test, String> columnTest, columnStatus, columnStart, columnStop, columnResult;

    @FXML
    private Button buttonToTest;

    @FXML
    public void handleButtonToTest(ActionEvent event) throws IOException {

        //Spara markerat test
        Test selectedTest = tableTests.getSelectionModel().getSelectedItem();

        try {

            //Om testets status inte är "klart" - byt scen till sidan för att göra testet
            if (!"Klart".equals(selectedTest.getCurrentStatus())) {
                URL test = getClass().getResource("Test.fxml");
                LogInController.getRoot().setCenter(FXMLLoader.load(test));
            } else {
                //Kontroll-ruta
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Du har redan genomfört provet.");

                alert.showAndWait();

            }

        } catch (NullPointerException ex) {
            System.out.println("Inget test markerat");
        }

    }

    public void setStatus(Test test) {

        int countQuestions = test.getQuestions().size();
        int countReponse = 0;
        String testStatus = "Ej avslutat";

        //Hur många svar finns det på frågorna?
        for (Question q : test.getQuestions()) {
            for (Response r : q.getResponses()) {
                if (r.getUserId() == logic.getSelectedUser().getUserId()) {
                    countReponse++;
                }
            }
        }

        System.out.println("Antal svar på testet " + countReponse + "/" + countQuestions);

        if (countQuestions == countReponse) {
            testStatus = "Klart";
        }

        test.setCurrentStatus(testStatus);

    }

    public void setResult(Test test) {
        int studentResponse = 0;
        String result = " ";
        try {

            if ("Klart".equals(test.getCurrentStatus())) {
                //Går igenom användarens test och lägger plussar på countern när svaren är rätt
                {
                    for (Question question : test.getQuestions()) {
                        for (QuestionOption option : question.getQuestionOptions()) {
                            if (option.isTrueFalse()) {
                                try {
                                    for (Response response : question.getResponses()) {
                                        if (response.getResponse().equals(option.getQuestionOption())) {
                                            studentResponse++;
                                        }
                                    }
                                } catch (NullPointerException ex) {
                                }
                            }

                            result = studentResponse + "/" + test.getQuestions().size();
                            
                        }
                    }
                }
            } else {

            }
            test.setCurrentResult(result);
        } catch (NullPointerException e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
        selectedCourse = logic.getSelectedCourse();
        labelCourse.setText(selectedCourse.getName());
        testList = FXCollections.observableArrayList();

        //Fyller testList med användarens test plus värdena status och resultat
        selectedCourse.getTests().forEach((a) -> {
            setStatus(a);
            setResult(a);
            testList.add(a);
        });

        columnTest.setCellValueFactory(new PropertyValueFactory<>("title")); //"title" är färltvariabel i klassen Test
        columnStart.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        columnStop.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("currentStatus"));
        columnResult.setCellValueFactory(new PropertyValueFactory<>("currentResult"));

        columnTest.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStart.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStop.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStatus.setCellFactory(TextFieldTableCell.forTableColumn());
        columnResult.setCellFactory(TextFieldTableCell.forTableColumn());

        tableTests.setItems(testList);

        //Gör buttonToTest aktiv när en rad är vald 
        buttonToTest.disableProperty().bind(
                Bindings.isEmpty(tableTests.getSelectionModel().getSelectedItems()));
    }

}
