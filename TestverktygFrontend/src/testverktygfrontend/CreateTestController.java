/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class CreateTestController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
