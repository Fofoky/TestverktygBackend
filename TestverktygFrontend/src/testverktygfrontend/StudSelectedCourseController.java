package testverktygfrontend;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
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
import testverktygfrontend.model.Course;
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
    private TableColumn<Test, String> columnTest, columnStatus, columnStart, columnStop;
    
    @FXML
    private Button buttonToTest;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
        selectedCourse = logic.getSelectedCourse();
        labelCourse.setText(selectedCourse.getName());
        testList = FXCollections.observableArrayList();
        
        selectedCourse.getTests().forEach((a) -> {
            testList.add(a);
        });
        
        
        columnTest.setCellValueFactory(new PropertyValueFactory<>("title"));
   //     columnStatus.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnStart.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        columnStop.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        
        columnTest.setCellFactory(TextFieldTableCell.forTableColumn());
        columnStart.setCellFactory(TextFieldTableCell.forTableColumn());      
        columnStop.setCellFactory(TextFieldTableCell.forTableColumn());
         
        tableTests.setItems(testList);
        
        
    }    
    
}
