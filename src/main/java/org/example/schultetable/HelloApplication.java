package org.example.schultetable;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{

            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene=new Scene(root);
            stage.setTitle("Schulte Table Game");
            // Load and set the application icon
            Image logo = new Image(getClass().getResourceAsStream("logo.png"));
            stage.getIcons().add(logo);
            String css=this.getClass().getResource("login.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);

            stage.setResizable(false);
            stage.show();

//
        }catch(Exception e){
//            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        launch(args);
    }
}