/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.Test;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TestController implements Initializable {
    
    private Logic logic;
    private Test selectedTest;
    private List<Question> questionList;
    private List<QuestionOption> questionOptionList;
    private List<QuestionOption> savedAnswers;
    
    @FXML Label labelTestName, labelQuestionId, labelProgress;
    
    @FXML TextArea textAreaQuestion;
    
    @FXML CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    
    //Previous och next, disabled vid start och slut. SaveTest blir visible vid sista frågan. 
    @FXML Button buttonPrevious, buttonNext, buttonSaveTest; 
    
    @FXML ProgressBar progressBar; //Går att koppla till property med bind
    
    
    
    public void handleButtonNextAction(ActionEvent event){
        
        
    }
    
    ChangeListener checkIfChecked1 = new ChangeListener<Boolean>(){
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue == true){
                checkBox2.setDisable(true);
                checkBox3.setDisable(true);
                checkBox4.setDisable(true);
            }
            else{
                checkBox2.setDisable(false);
                checkBox3.setDisable(false);
                checkBox4.setDisable(false);
            }
        }
            
    };
    
        ChangeListener checkIfChecked2 = new ChangeListener<Boolean>(){
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue == true){
                checkBox1.setDisable(true);
                checkBox3.setDisable(true);
                checkBox4.setDisable(true);
            }
            else{
                checkBox1.setDisable(false);
                checkBox3.setDisable(false);
                checkBox4.setDisable(false);
            }
        }
            
    };
        
            ChangeListener checkIfChecked3 = new ChangeListener<Boolean>(){
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue == true){
                checkBox2.setDisable(true);
                checkBox1.setDisable(true);
                checkBox4.setDisable(true);
            }
            else{
                checkBox2.setDisable(false);
                checkBox1.setDisable(false);
                checkBox4.setDisable(false);
            }
        }
            
    };
            
        ChangeListener checkIfChecked4 = new ChangeListener<Boolean>(){
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue == true){
                checkBox2.setDisable(true);
                checkBox3.setDisable(true);
                checkBox1.setDisable(true);
            }
            else{
                checkBox2.setDisable(false);
                checkBox3.setDisable(false);
                checkBox1.setDisable(false);
            }
        }
            
    };        
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkBox1.selectedProperty().addListener(checkIfChecked1);
        checkBox2.selectedProperty().addListener(checkIfChecked2);
        checkBox3.selectedProperty().addListener(checkIfChecked3);
        checkBox4.selectedProperty().addListener(checkIfChecked4);
        
        logic = Logic.getInstance();
        selectedTest = logic.getSelectedTest();
        questionList = new ArrayList();
        questionOptionList = new ArrayList();
        savedAnswers = new ArrayList();
        
        // Sparar de questions som finns för ett test i en ny lista.
        selectedTest.getQuestions().forEach((a) -> {
            questionList.add(a);
            
        });
        
        // Sparar de QuestionOptions som finns för alla frågor i en ny lista.
        for(Question q : questionList){
            for(QuestionOption qO : q.getQuestionOptions()){
                questionOptionList.add(qO);
                System.out.println(qO.getQuestionOption());
            }
        }
        
        
        labelQuestionId.setText(String.valueOf(questionList.get(0).getQuestionId()));
        textAreaQuestion.setText(questionList.get(0).getQuestion());
        
        labelTestName.setText(selectedTest.getTitle());
        
        
    }    
    
}
