/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author annafock
 */
public class TreeViewController implements Initializable {

    @FXML
    private TreeView treeViewMenu;

    private TreeItem<String> root;
    private TreeItem<String> node1;
    private TreeItem<String> subNode1;

    public void loadTreeViewMenu() {
        root = new TreeItem<>("Kurser");
        node1 = new TreeItem<>("Kurs 1");

        subNode1 = new TreeItem<>("Prov");

        node1.getChildren().addAll(subNode1);

        root.getChildren().addAll(node1);
        treeViewMenu.setRoot(root);

    }

    @FXML
    public void handleTreeView(MouseEvent event) {
        TreeItem<String> selectedItem = (TreeItem<String>) treeViewMenu.getSelectionModel().getSelectedItem();

        if (selectedItem == node1) {
            try {

                URL paneOneUrl = getClass().getResource("StudSelectedCourse.fxml");
                AnchorPane paneOne = FXMLLoader.load(paneOneUrl);

                BorderPane border = LogInController.getRoot();
                border.setCenter(paneOne);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTreeViewMenu();
    }

}
