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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class PrimaryController implements Initializable {
   
    @FXML private TreeView treeViewMenu;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
        TreeItem<String> root = new TreeItem<>("Kurser");
        TreeItem<String> node1 = new TreeItem<>("Kurs 1");
        TreeItem<String> node2 = new TreeItem<>("Kurs 2");
        TreeItem<String> node3 = new TreeItem<>("Kurs 3");

        TreeItem<String> subNode1 = new TreeItem<>("Prov");
        TreeItem<String> subNode2 = new TreeItem<>("Omprov");

        node1.getChildren().addAll(subNode1, subNode2);

        root.getChildren().addAll(node1, node2, node3);
        treeViewMenu.setRoot(root);
    }

}
