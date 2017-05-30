package testverktygfrontend;

import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import testverktygfrontend.dbconnector.DBconnector;
import testverktygfrontend.model.User;

/**
 *
 * @author annafock
 */
public class TestverktygFrontend extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
       
        
        
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBconnector db = new DBconnector();
        List<User> users = db.getUsers();
        
        launch(args);
    }
    
}
