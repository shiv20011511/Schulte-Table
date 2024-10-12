package org.example.schultetable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void GameRules(ActionEvent e)throws IOException {
        root= FXMLLoader.load(getClass().getResource("gameRules.fxml"));
        stage =(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css=this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void Abouthustler(ActionEvent e)throws IOException{
        root= FXMLLoader.load(getClass().getResource("Abouthustler.fxml"));
        stage =(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css=this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }
    public void AboutSchulte(ActionEvent e)throws IOException{
        root= FXMLLoader.load(getClass().getResource("Aboutschulte.fxml"));
        stage =(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css=this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void GameArea(ActionEvent e)throws IOException{
        root= FXMLLoader.load(getClass().getResource("GameArea.fxml"));
        stage =(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css=this.getClass().getResource("gamearea.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }

    public void exit(ActionEvent e){
        System.exit(0);
    }



}
