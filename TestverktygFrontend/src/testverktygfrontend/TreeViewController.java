package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.Course;
import testverktygfrontend.model.Test;

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TreeViewController implements Initializable {

    private Logic logic;

    @FXML
    private Label labelUserName;

    @FXML
    private TreeView treeViewMenu;

    private TreeItem<String> root;
    private TreeItem<String> node1;
//    private TreeItem<String> subNode1;
    @FXML
    private Text logouttext;

    public void loadTreeViewMenu() {
        root = new TreeItem<>("Kurser");
        root.expandedProperty().set(true);
        try {
            for (int i = 0; i < logic.getSelectedUser().getCourses().size(); i++) {
                node1 = new TreeItem<>(logic.getSelectedUser().getCourses().get(i).getName());
//                if (logic.getSelectedUser().getUserRole().equals("Student")) {
//                    for (int j = 0; j < logic.getSelectedUser().getCourses().get(i).getTests().size(); j++) {
//                        subNode1 = new TreeItem<>("Test: " + logic.getSelectedUser().getCourses().get(i).getTests().get(j).getTitle());
//                        node1.getChildren().add(subNode1);
//                    }
//                }

                root.getChildren().add(node1);
            }
        } catch (NullPointerException e) {

            // DB is empty
        }

        treeViewMenu.setRoot(root);

    }

    @FXML
    public void handleTreeView(MouseEvent event) {
        String name;
        try {
            TreeItem<String> selectedItem = (TreeItem<String>) treeViewMenu.getSelectionModel().getSelectedItem();

            name = selectedItem.toString().substring(18, selectedItem.toString().length() - 2).trim();
        } catch (NullPointerException ex) {
            name = "Kurser";
        }

        if (!name.equals("Kurser")) {

            try {
                String t = name.substring(0, 4);
                if (!t.equals("Test")) {
                    throw new StringIndexOutOfBoundsException();
                }

                Test test = null;
                for (Course c : logic.getSelectedUser().getCourses()) {
                    for (Test tests : c.getTests()) {
                        if (tests.getTitle().equals(name.substring(6))) {
                            test = tests;
                        }
                    }
                }

                logic.setSelectedTest(test); // skickar valt test till logic för vidare användning

                try {
                    URL paneOneUrl = getClass().getResource("Test.fxml");
                    AnchorPane paneOne = (AnchorPane) FXMLLoader.load(paneOneUrl);

                    BorderPane border = LogInController.getRoot();
                    border.setCenter(paneOne);

                } catch (IOException ee) {
                    ee.printStackTrace();
                }

            } catch (StringIndexOutOfBoundsException e) {

                Course course = null;
                for (Course c : logic.getSelectedUser().getCourses()) {
                    if (c.getName().equals(name)) {
                        course = c;
                    }
                }

                logic.setSelectedCourse(course); // skickar vald kurs till logic för vidare användning i scenen

                try {
                    if (logic.getSelectedUser().getUserRole().equals("Student")) {

                        URL paneOneUrl = getClass().getResource("StudSelectedCourse.fxml");
                        AnchorPane paneOne = (AnchorPane) FXMLLoader.load(paneOneUrl);

                        BorderPane border = LogInController.getRoot();
                        border.setCenter(paneOne);

                    } else {

                        URL paneOneUrl = getClass().getResource("TeacherSelectedCourse.fxml");
                        AnchorPane paneOne = (AnchorPane) FXMLLoader.load(paneOneUrl);

                        BorderPane border = LogInController.getRoot();
                        border.setCenter(paneOne);

                    }

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
        labelUserName.setText("Inloggad som " + logic.getSelectedUser().getName());
        loadTreeViewMenu();
    }

    @FXML
    private void handleTreeView(ContextMenuEvent event) {
    }

    @FXML
    private void handlelogout(MouseEvent event) {
        
    }

}
