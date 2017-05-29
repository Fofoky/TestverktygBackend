/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testverktygfrontend;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

//    @FXML
//    private AnchorPane sceneArea, scene2;
    
    @FXML Button button1, button2;
    
    @FXML Pane content;

    private TreeItem<String> root;
    private TreeItem<String> node1;
    private TreeItem<String> node2;
    private TreeItem<String> node3;

    private TreeItem<String> subNode1;
    private TreeItem<String> subNode2;

    @FXML
    private TreeView treeViewMenu;

    public void loadTreeViewMenu() {
        root = new TreeItem<>("Kurser");
        node1 = new TreeItem<>("Kurs 1");
        node2 = new TreeItem<>("Kurs 2");
        node3 = new TreeItem<>("Kurs 3");

        subNode1 = new TreeItem<>("Prov");
        subNode2 = new TreeItem<>("Omprov");

        node1.getChildren().addAll(subNode1, subNode2);

        root.getChildren().addAll(node1, node2, node3);
        treeViewMenu.setRoot(root);

    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
         System.out.println("click! taskBarButton2");
        content.getChildren().clear();
        content.getChildren().add(FXMLLoader.load(getClass().getResource("StudSelectedCourse.fxml")));

    }

//    @FXML
//    public void handleTreeView(MouseEvent event) throws IOException {
//        TreeItem<String> selectedItem = (TreeItem<String>) treeViewMenu.getSelectionModel().getSelectedItem();

//    }
    
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {

       // loadTreeViewMenu();
    }

}
