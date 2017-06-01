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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TestController implements Initializable {

    @FXML Label labelTestName, labelQuestionId, labelProgress;
    
    @FXML TextArea textAreaQuestion;
    
    @FXML CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    
    //Previous och next, disabled vid start och slut. SaveTest blir visible vid sista frågan. 
    @FXML Button buttonPrevious, buttonNext, buttonSaveTest; 
    
    @FXML ProgressBar progressBar; //Går att koppla till property med bind
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
