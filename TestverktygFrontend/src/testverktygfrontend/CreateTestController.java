package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Question;
import testverktygfrontend.model.QuestionOption;
import testverktygfrontend.model.TemporaryQuestionCreate;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;

public class CreateTestController implements Initializable {

    private Logic logic;
    private ObservableList<TemporaryQuestionCreate> questionList;
    private Test test = null;
    private ArrayList<Question> questions = null;
    private ArrayList<QuestionOption> options = null;

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
            if (test == null) {
                test = new Test();
                test.setTitle(textFieldTestName.getText().trim());
                test = logic.addTest(test);
                questions = new ArrayList();
                options = new ArrayList();
                textFieldTestName.setEditable(false);
                buttonSaveTest.setText("Spara ändringar");
            }

            for (TemporaryQuestionCreate temp : questionList) {
                if (!temp.getSavedToDb()) {

                    Question q = new Question();
                    q = logic.addQuestion(temp.getQuestion(), test.getIdTest());

                    boolean b = true;
                    logic.addQuestionOption(temp.getOption1(), b, q.getQuestionId());
                    options.add(new QuestionOption(temp.getOption1(), b, q));

                    b = false;
                    logic.addQuestionOption(temp.getOption2(), b, q.getQuestionId());
                    options.add(new QuestionOption(temp.getOption2(), b, q));

                    logic.addQuestionOption(temp.getOption3(), b, q.getQuestionId());
                    options.add(new QuestionOption(temp.getOption3(), b, q));

                    logic.addQuestionOption(temp.getOption4(), b, q.getQuestionId());
                    options.add(new QuestionOption(temp.getOption4(), b, q));

                    q.setQuestionOptions(options);
                    questions.add(q);
                    temp.setSavedToDb(true);
                }
            }
            test.setQuestions(questions);

            for (User user : logic.getUsers()) {
                for (Course course : user.getCourses()) {
                    if (course.getCourseId() == logic.getSelectedCourse().getCourseId()) {
                        course.deleteTest(test); // tar bort gamal version av tetstet
                        course.addTest(test); // lägger till den uppdaterade versionen
                    }
                }
            }

            textAreaQuestion.clear();
            textFieldOpt1.clear();
            textFieldOpt2.clear();
            textFieldOpt3.clear();
            textFieldOpt4.clear();

        } catch (NullPointerException e) {
            System.out.println();

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

        if (logic.getSelectedTest() != null) {
            test = logic.getSelectedTest();
            textFieldTestName.setText(test.getTitle());
            textFieldTestName.setEditable(false);
            buttonSaveTest.setText("Uppdatera");
            questions = new ArrayList();
            options = new ArrayList();

            for (Question question : test.getQuestions()) {
                TemporaryQuestionCreate newQuestion = new TemporaryQuestionCreate();

                newQuestion.setId(questionList.size() + 1);
                newQuestion.setQuestion(question.getQuestion());

                newQuestion.setOption1(question.getQuestionOptions().get(0).getQuestionOption());
                newQuestion.setOption2(question.getQuestionOptions().get(1).getQuestionOption());
                newQuestion.setOption3(question.getQuestionOptions().get(2).getQuestionOption());
                newQuestion.setOption4(question.getQuestionOptions().get(3).getQuestionOption());
                newQuestion.setSavedToDb(true);
                questions.add(question);
                questionList.add(newQuestion);
            }
        }

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
