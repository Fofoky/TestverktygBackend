package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;



public class CreateTestController implements Initializable {

    private Logic logic;
    private ObservableList<Object> questionList;

    @FXML
    Label labelCourse;

    @FXML
    TableView tableCreateTest;

    @FXML
    TableColumn<Question, Integer> columnId;

    @FXML
    TableColumn<Question, String> columnQuestion;

    @FXML
    TableColumn<QuestionOption, String> columnOpt1, columnOpt2, columnOpt3, columnOpt4;

    @FXML
    TextArea textAreaQuestion;

    @FXML
    TextField textFieldTestName, textFieldOpt1, textFieldOpt2, textFieldOpt3, textFieldOpt4;

    @FXML
    Button buttonAddQuestion; //Default disabled - enable när alla fält har innehåll

    @FXML
    Button buttonSaveTest; //Provet sparas egentligen ändå, men knappen leder tillbaka till kurssidan

    @FXML
    private void saveTest(ActionEvent event) throws IOException {
        try {
            String testName = textFieldTestName.getText().trim();

        } catch (NullPointerException e) {

        }

    }

    @FXML
    private void addQuestion(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
        labelCourse.setText(logic.getSelectedCourse().getName());
        
        questionList = FXCollections.observableArrayList();
        
        columnId.setCellValueFactory(new PropertyValueFactory<>("questionId"));
        columnQuestion.setCellValueFactory(new PropertyValueFactory<>("question"));
        
        
        columnOpt1.setCellValueFactory(new PropertyValueFactory<>("questionOption"));
        columnOpt2.setCellValueFactory(new PropertyValueFactory<>("questionOption"));
        columnOpt3.setCellValueFactory(new PropertyValueFactory<>("questionOption"));
        columnOpt4.setCellValueFactory(new PropertyValueFactory<>("questionOption"));

        columnId.setCellFactory(TextFieldTableCell.forTableColumn());
        columnQuestion.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt1.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt2.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt3.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt4.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        
        tableCreateTest.setItems(questionList);

    }

}
