package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
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
import javafx.util.converter.IntegerStringConverter;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.TemporaryQuestionCreate;
import testverktygfrontend.model.Test;

public class CreateTestController implements Initializable {

    private Logic logic;
    private ObservableList<TemporaryQuestionCreate> questionList;

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
            Test test = new Test();
            //test.setCourse(logic.getSelectedCourse());
            test.setTitle(textFieldTestName.getText().trim());
            test = logic.addTest(test);

            for (TemporaryQuestionCreate temp : questionList) {
                Question q = new Question();
                q = logic.addQuestion(temp.getQuestion(), test.getIdTest());
                boolean b = true;
                logic.addQuestionOption(temp.getOption1(), b, q.getQuestionId());
                b = false;
                logic.addQuestionOption(temp.getOption2(), b, q.getQuestionId());
                logic.addQuestionOption(temp.getOption3(), b, q.getQuestionId());
                logic.addQuestionOption(temp.getOption4(), b, q.getQuestionId());
            }

            textFieldTestName.clear();
            textAreaQuestion.clear();
            textFieldOpt1.clear();
            textFieldOpt2.clear();
            textFieldOpt3.clear();
            textFieldOpt4.clear();
            questionList.clear();
            

        } catch (NullPointerException e) {

        }

    }

    @FXML
    private void addQuestion(ActionEvent event) throws IOException {
        TemporaryQuestionCreate newQuestion = new TemporaryQuestionCreate();

        newQuestion.setId(questionList.size() + 1);
        newQuestion.setQuestion(textAreaQuestion.getText());
        newQuestion.setOption1(textFieldOpt1.getText());
        newQuestion.setOption2(textFieldOpt2.getText());
        newQuestion.setOption3(textFieldOpt3.getText());
        newQuestion.setOption4(textFieldOpt4.getText());

        questionList.add(newQuestion);
        textAreaQuestion.clear();
        textFieldOpt1.clear();
        textFieldOpt2.clear();
        textFieldOpt3.clear();
        textFieldOpt4.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
        labelCourse.setText(logic.getSelectedCourse().getName());
        buttonBinds();

        questionList = FXCollections.observableArrayList();

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnQuestion.setCellValueFactory(new PropertyValueFactory<>("question"));

        columnOpt1.setCellValueFactory(new PropertyValueFactory<>("option1"));
        columnOpt2.setCellValueFactory(new PropertyValueFactory<>("option2"));
        columnOpt3.setCellValueFactory(new PropertyValueFactory<>("option3"));
        columnOpt4.setCellValueFactory(new PropertyValueFactory<>("option4"));

        columnId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        columnQuestion.setCellFactory(TextFieldTableCell.forTableColumn());

        columnOpt1.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt2.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt3.setCellFactory(TextFieldTableCell.forTableColumn());
        columnOpt4.setCellFactory(TextFieldTableCell.forTableColumn());

        tableCreateTest.setItems(questionList);

    }

    private void buttonBinds() {

        BooleanBinding bb = new BooleanBinding() { // bindar button saveTest med testname textField
            {
                super.bind(textFieldTestName.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return (textFieldTestName.getText().isEmpty());
            }
        };
        buttonSaveTest.disableProperty().bind(bb);

        BooleanBinding b = new BooleanBinding() { // bindar button addQuestion med samtliga textfiels
            {
                super.bind(textAreaQuestion.textProperty(),
                        textFieldOpt1.textProperty(),
                        textFieldOpt2.textProperty(),
                        textFieldOpt3.textProperty(),
                        textFieldOpt4.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return (textAreaQuestion.getText().isEmpty()
                        || textFieldOpt1.getText().isEmpty()
                        || textFieldOpt2.getText().isEmpty()
                        || textFieldOpt3.getText().isEmpty()
                        || textFieldOpt4.getText().isEmpty());
            }
        };
        buttonAddQuestion.disableProperty().bind(b);

    }

}
