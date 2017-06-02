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
import testverktygfrontend.model.Test;

public class StudSelectedCourseController implements Initializable {

    private Logic logic;
    private Test test;
    private Course selectedCourse;
    private ObservableList<Test> testList;

    @FXML
    private Label labelCourse;

    @FXML
    private TableView<Test> tableTests;

    @FXML
    private TableColumn<Test, String> columnTest, columnStatus, columnStart, columnStop;

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

    public void setColumnStatus(Test test) {

        int countQuestions = 0;
        int countReponse = 0;
        String testStatus = "Ej avslutat";

        //Hur många frågor är det i det här testet?
        for (int i = 0; i < testList.size(); i++) {
            countQuestions = testList.get(i).getQuestions().size();
            System.out.println("Antal frågor i testet " + countQuestions);
        }

        //Hur många svar finns det på frågorna?
        for (int i = 0; i < testList.size(); i++) {
            countReponse = testList.get(i).getQuestions().get(i).getResponses().size();
            System.out.println("Antal svar på testet " + countReponse);
        }

        if (countQuestions == countReponse) {
            testStatus = "Klart";
        }

        test.setCurrentStatus(testStatus);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
        selectedCourse = logic.getSelectedCourse();
        labelCourse.setText(selectedCourse.getName());
        testList = FXCollections.observableArrayList();

        selectedCourse.getTests().forEach((a) -> {
            setColumnStatus(a);
            testList.add(a);
        });

        columnTest.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnStart.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        columnStop.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("currentStatus"));

        columnTest.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStart.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStop.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStatus.setCellFactory(TextFieldTableCell.forTableColumn());

        tableTests.setItems(testList);

        //Gör buttonToTest aktiv när en rad är vald 
        buttonToTest.disableProperty().bind(
                Bindings.isEmpty(tableTests.getSelectionModel().getSelectedItems()));
    }

}
