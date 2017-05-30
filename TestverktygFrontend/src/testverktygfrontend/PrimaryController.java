package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;

public class PrimaryController implements Initializable {

    private Logic logic;

    @FXML
    Button button1, button2;

    @FXML
    Pane content;

    private TreeItem<String> root;
    private TreeItem<String> node1;
    private TreeItem<String> subNode1;

    @FXML
    private TreeView treeViewMenu;

    public void loadTreeViewMenu(User user) {
        root = new TreeItem<>("Kurser");

        for (int i = 0; i < user.getCourses().size(); i++) {
            node1 = new TreeItem<>(user.getCourses().get(i).getName());
            for (int j = 0; j < user.getCourses().get(i).getTests().size(); j++) {
                subNode1 = new TreeItem<>(user.getCourses().get(i).getTests().get(j).getTitle());
                node1.getChildren().add(subNode1);
            }

            root.getChildren().add(node1);
        }

        treeViewMenu.setRoot(root);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("click! taskBarButton2");
        content.getChildren().clear();
        content.getChildren().add(FXMLLoader.load(getClass().getResource("StudSelectedCourse.fxml")));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logic = Logic.getInstance();
        User user = logic.getUser(2);
        loadTreeViewMenu(user);

        //Listener till TreeView ############################################
        treeViewMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String name = newValue.toString().substring(18, newValue.toString().length() - 2).trim();

            if (!name.equals("Kurser")) {

                try {
                    String t = name.substring(0, 4);
                    if (!t.equals("Test")) {
                        throw new StringIndexOutOfBoundsException();
                    }
                    
                    Test test = null;
                    for(Course c : user.getCourses()){
                        for(Test tests : c.getTests()){
                            if(tests.getTitle().equals(name.substring(6))){
                                test = tests;
                            }
                        }
                    }
                    
                    System.out.println(test.getIdTest());
                    

                    // Scene för Test <<<<<<-------------------------------<<<<<<
                    

                } catch (StringIndexOutOfBoundsException e) {
                    
                    Course course = null;
                    for(Course c : user.getCourses()){
                        if(c.getName().equals(name)){
                            course = c;
                        }
                    }
                    
                    System.out.println(course.getCourseId());
                    
                   // Scene för Course <<<<<<---------------------------<--<<<<<<
                   
                    
                }
            }
        });
        
        //#####################################################################
    }

}
