package testverktygfrontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import testverktygfrontend.logic.Logic;
import testverktygfrontend.model.User;

public class LogInController implements Initializable {

    private Logic logic;
    private User selectedUser;
    private BooleanProperty pass;

    @FXML
    private TextField textFieldUserName, textFieldPassword;

    @FXML
    private Button btnLogIn;

    // Creating a static root to pass to the controller
    private static BorderPane root = new BorderPane();

    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    @FXML
    private void handleLogInButton(ActionEvent event) throws IOException {

        logic.setSelectedUser(selectedUser);

        //Definierar sökväg för menyn och fönstret
        URL treeViewURL = getClass().getResource("TreeView.fxml");
        URL welcomeUrl = getClass().getResource("Welcome.fxml");

        // definierar var i root som treeview respektive huvudfönstret ska ligga
        root.setLeft(FXMLLoader.load(treeViewURL));

        root.setCenter(FXMLLoader.load(welcomeUrl));

        //Skapar ny scen av root och definierar måtten 
        Scene scene = new Scene(root, 700, 500);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();//Här hämtar nuvarande scen
        stg.setScene(scene);//byter gamla stagen mot den nya      

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logic = Logic.getInstance();
       
        logic.updateList(); // läser in alla listor till logic

        pass = new SimpleBooleanProperty(true);
        btnLogIn.disableProperty().bindBidirectional(pass);

        textFieldUserName.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                for (User user : logic.getUsers()) {
                    if (user.getName().equals(newValue)) {
                        textFieldPassword.disableProperty().set(false);
                        selectedUser = user;
                        break;
                    } else {
                        textFieldPassword.clear();
                        textFieldPassword.disableProperty().set(true);
                        pass.set(true);
                    }
                }

            }

        });

        textFieldPassword.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                boolean b = selectedUser.getPassword().equals(textFieldPassword.getText());

                if (b) {
                    pass.set(false);
                } else {
                    pass.set(true);
                }

            }

        });
    }

}
