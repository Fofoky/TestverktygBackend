package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Test;
import testverktygfrontend.model.User;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TreeViewController implements Initializable {

    private Logic logic;
    private User user;

    @FXML
    private TreeView treeViewMenu;

    private TreeItem<String> root;
    private TreeItem<String> node1;
    private TreeItem<String> subNode1;

    public void loadTreeViewMenu() {
        root = new TreeItem<>("Kurser");

        for (int i = 0; i < user.getCourses().size(); i++) {
            node1 = new TreeItem<>(user.getCourses().get(i).getName());
            for (int j = 0; j < user.getCourses().get(i).getTests().size(); j++) {
                subNode1 = new TreeItem<>("Test: " + user.getCourses().get(i).getTests().get(j).getTitle());
                node1.getChildren().add(subNode1);
            }

            root.getChildren().add(node1);
        }

        treeViewMenu.setRoot(root);

    }

    @FXML
    public void handleTreeView(MouseEvent event) {
        TreeItem<String> selectedItem = (TreeItem<String>) treeViewMenu.getSelectionModel().getSelectedItem();
        String name = selectedItem.toString().substring(18, selectedItem.toString().length() - 2).trim();

            if (!name.equals("Kurser")) {

                try {
                    String t = name.substring(0, 4);
                    if (!t.equals("Test")) {
                        throw new StringIndexOutOfBoundsException();
                    }

                    Test test = null;
                    for (Course c : user.getCourses()) {
                        for (Test tests : c.getTests()) {
                            if (tests.getTitle().equals(name.substring(6))) {
                                test = tests;
                            }
                        }
                    }

                    System.out.println(test.getIdTest());

                    // Scene för Test <<<<<<-------------------------------<<<<<<
                    
                    
                } catch (StringIndexOutOfBoundsException e) {

                    Course course = null;
                    for (Course c : user.getCourses()) {
                        if (c.getName().equals(name)) {
                            course = c;
                        }
                    }

                    System.out.println(course.getCourseId());

                    try {

                        URL paneOneUrl = getClass().getResource("StudSelectedCourse.fxml");
                        AnchorPane paneOne = (AnchorPane) FXMLLoader.load(paneOneUrl);

                        BorderPane border = LogInController.getRoot();
                        border.setCenter(paneOne);

                    } catch (IOException ee) {
                        ee.printStackTrace();
                    }

                }
            }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logic = Logic.getInstance();
        user = logic.getUser(2);
        loadTreeViewMenu();
    }

}
