/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend;

import java.awt.CheckboxGroup;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import testverktygfrontend.model.User;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TestController implements Initializable {
    
    private Logic logic;
    private Test selectedTest;
    private User selectedUser;
    private Question selectedQuestion;
    private List<Question> questionList;
    private ObservableList<QuestionOption> questionOptionList;
    private List<QuestionOption> savedAnswers;
    private IntegerProperty counter;
    private boolean ended = false;
    
    @FXML Label labelTestName, labelQuestionId, labelProgress;
    
    @FXML TextArea textAreaQuestion;
    
    @FXML CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    
    //Previous och next, disabled vid start och slut. SaveTest blir visible vid sista frågan. 
    @FXML Button buttonPrevious, buttonNext, buttonSaveTest; 
    
    @FXML ProgressBar progressBar; //Går att koppla till property med bind
    
    public void handleButtonNextAction(ActionEvent event){
        buttonPrevious.setDisable(false);
        counter.set(counter.getValue()+1);
        
        checkBox1.setDisable(false);
        checkBox2.setDisable(false);
        checkBox3.setDisable(false);
        checkBox4.setDisable(false);
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        
        
        try{
            if(selectedQuestion==(questionList.get(questionList.size()-1))){
                storeAnswers();
                ended = true;
            }
        }catch(IndexOutOfBoundsException e){
            
        }
        
    }
    
    public void storeAnswers(){
        buttonNext.setDisable(true);
        buttonSaveTest.setDisable(false);
    }
    
    public void handleButtonSaveTestAction(ActionEvent event){
        String response;
        int qId;
        int uId;
       
        for(QuestionOption q : savedAnswers){
            
            
            
            response = q.getQuestionOption();
            
           
            qId = q.getQuestion().getQuestionId();
            
            uId = selectedUser.getUserId();
            
            
            
           logic.addResponse(response, qId, uId, q.getQuestion());
            
            
        }
    }
    
    public void handleButtonBackAction(ActionEvent event){
        counter.set(counter.getValue()-1);
        
        if(questionList.get(0)==selectedQuestion){
            buttonPrevious.setDisable(true);
        }  
    }
    
    ChangeListener checkIfChecked1 = new ChangeListener<Boolean>(){
        
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(newValue == true){
                checkBox2.setDisable(true);
                checkBox3.setDisable(true);
                checkBox4.setDisable(true);
                if(ended == false){
                    buttonNext.setDisable(false);
                }
                
                for(QuestionOption q : questionOptionList){
                    if(q.getQuestionOption().equals(checkBox1.getText())){
                        q.setQuestion(selectedQuestion);
                        savedAnswers.add(q);
                    }
                }
                
            }
            else{
                checkBox2.setDisable(false);
                checkBox3.setDisable(false);
                checkBox4.setDisable(false);
                buttonNext.setDisable(true);
                
                savedAnswers.removeIf(s -> s.getQuestionOption().equals(checkBox1.getText()));
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
                if(ended == false){
                    buttonNext.setDisable(false);
                }
                
                for(QuestionOption q : questionOptionList){
                    if(q.getQuestionOption().equals(checkBox2.getText())){
                        q.setQuestion(selectedQuestion);
                        savedAnswers.add(q);
                    }
                }
            }
            else{
                checkBox1.setDisable(false);
                checkBox3.setDisable(false);
                checkBox4.setDisable(false);
                buttonNext.setDisable(true);
                
                savedAnswers.removeIf(s -> s.getQuestionOption().equals(checkBox2.getText()));
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
                if(ended == false){
                    buttonNext.setDisable(false);
                }
                
                for(QuestionOption q : questionOptionList){
                    if(q.getQuestionOption().equals(checkBox3.getText())){
                        q.setQuestion(selectedQuestion);
                        savedAnswers.add(q);
                    }
                }
            }
            else{
                checkBox2.setDisable(false);
                checkBox1.setDisable(false);
                checkBox4.setDisable(false);
                buttonNext.setDisable(true);
                
                savedAnswers.removeIf(s -> s.getQuestionOption().equals(checkBox3.getText()));
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
                if(ended == false){
                    buttonNext.setDisable(false);
                }
                
                for(QuestionOption q : questionOptionList){
                    if(q.getQuestionOption().equals(checkBox4.getText())){
                        q.setQuestion(selectedQuestion);
                        savedAnswers.add(q);
                    }
                }
            }
            else{
                checkBox2.setDisable(false);
                checkBox3.setDisable(false);
                checkBox1.setDisable(false);
                buttonNext.setDisable(true);
                
                savedAnswers.removeIf(s -> s.getQuestionOption().equals(checkBox4.getText()));
            }

        }
            
    };

    ChangeListener changeListener = new ChangeListener() {
      @Override
      public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
          
        selectedQuestion = selectedTest.getQuestions().get((int) newValue);
        textAreaQuestion.setText(selectedQuestion.getQuestion());
        labelTestName.setText(selectedTest.getTitle());
        labelQuestionId.setText(String.valueOf(selectedQuestion.getQuestionId()));
        labelProgress.setText(String.valueOf(selectedQuestion.getQuestionId()) + " / " + questionList.size());
        checkBox1.setText(selectedQuestion.getQuestionOptions().get(0).getQuestionOption());
        checkBox2.setText(selectedQuestion.getQuestionOptions().get(1).getQuestionOption());
        checkBox3.setText(selectedQuestion.getQuestionOptions().get(2).getQuestionOption());
        checkBox4.setText(selectedQuestion.getQuestionOptions().get(3).getQuestionOption());
        
      }
    };
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logic = Logic.getInstance();
        selectedTest = logic.getSelectedTest();
        selectedUser = logic.getSelectedUser();
        savedAnswers = new ArrayList();counter= new SimpleIntegerProperty();
        counter = new SimpleIntegerProperty();
        buttonNext.setDisable(true);
        buttonPrevious.setDisable(true);
        buttonSaveTest.setDisable(true);
        questionList = new ArrayList();
        questionOptionList = FXCollections.observableArrayList();
        
        // Sparar de questions som finns för ett test i en ny lista.
        selectedTest.getQuestions().forEach((a) -> {
            questionList.add(a);
            
        });
        
        questionList.forEach((a) -> {
            a.getQuestionOptions().forEach((b) -> {
                questionOptionList.add(b);
            });
        });
        

        
        
        selectedQuestion = selectedTest.getQuestions().get(0);
        textAreaQuestion.setText(selectedQuestion.getQuestion());
        labelTestName.setText(selectedTest.getTitle());
        labelQuestionId.setText(String.valueOf(selectedQuestion.getQuestionId()));
        labelProgress.setText(String.valueOf(selectedQuestion.getQuestionId()) + " / " + questionList.size());
        checkBox1.setText(selectedQuestion.getQuestionOptions().get(0).getQuestionOption());
        checkBox2.setText(selectedQuestion.getQuestionOptions().get(1).getQuestionOption());
        checkBox3.setText(selectedQuestion.getQuestionOptions().get(2).getQuestionOption());
        checkBox4.setText(selectedQuestion.getQuestionOptions().get(3).getQuestionOption());
        
        progressBar.progressProperty().bind(counter.divide(questionList.size()*1.0));
        counter.addListener(changeListener);
        checkBox1.selectedProperty().addListener(checkIfChecked1);
        checkBox2.selectedProperty().addListener(checkIfChecked2);
        checkBox3.selectedProperty().addListener(checkIfChecked3);
        checkBox4.selectedProperty().addListener(checkIfChecked4);
        
    }    
    
}
