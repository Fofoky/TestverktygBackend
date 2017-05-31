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
import testverktygfrontend.model.Test;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TeacherSelectedCoursController implements Initializable {
    
    @FXML
    private Label labelCourse;
    
    @FXML
    private TableView<Test> tableTeacherTests, tableStudentTestResult;
    
    @FXML
    private TableColumn<Test, String> columnTest, columnStatus, columnStudent, columnResult;
    
    @FXML
    private TableColumn<Test, Date> columnStart, columnStop; //Om fel, dubbelkolla att rätt import gjorts till Date
    
    @FXML
    private Label labelSelectedTest;
    
    @FXML
    private Button buttonCreateTest, buttonDeleteTest, buttonEditTest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
