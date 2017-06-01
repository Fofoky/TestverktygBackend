/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Test;


public class StudSelectedCourseController implements Initializable {
    
    private Logic logic;
    private Course selectedCourse;
    
    @FXML
    private Label labelCourse;
    
    @FXML
    private TableView<Test> tableTests;
    
    @FXML
    private TableColumn<Test, String> columnTest, columnStatus;
    
    @FXML
    private TableColumn<Test, Date> columnStart, columnStop; //Om fel, dubbelkolla att rätt import gjorts till Date
    
    @FXML
    private Button buttonToTest;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
        selectedCourse = logic.getSelectedCourse();
        labelCourse.setText(selectedCourse.getName());
    }    
    
}
