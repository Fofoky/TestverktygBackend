package testverktygfrontend;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Test;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TeacherSelectedCourseController implements Initializable {
    
    private Logic logic;
    private ObservableList<Test> testList;
    
    @FXML
    private Label labelCourse;
    
    @FXML
    private TableView<Test> tableTests, tableStudentTestResult;
    
    @FXML
    private TableColumn<Test, String> columnTest, columnStatus, columnStudent, columnResult, columnStart, columnStop;
    
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
        logic = Logic.getInstance();
        labelCourse.setText(logic.getSelectedCourse().getName());
        
        testList = FXCollections.observableArrayList();
        
        logic.getSelectedCourse().getTests().forEach((a) -> {
            testList.add(a);
        });
        
        columnTest.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnStart.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        columnStop.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        
        columnTest.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStart.setCellFactory(TextFieldTableCell.forTableColumn());      
        columnStop.setCellFactory(TextFieldTableCell.forTableColumn());
         
        tableTests.setItems(testList);
    }    
    
}
