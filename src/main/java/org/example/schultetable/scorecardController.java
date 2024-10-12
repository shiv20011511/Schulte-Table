package org.example.schultetable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class scorecardController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label Score;
    @FXML
    Label Scorefeed;

    @FXML
    Label gamestop;



    public void displayScore(int x,String s){
        String sfeed="";
        if(x<=10){
            sfeed="Average";
        }else if(x>=11 && x<=20){
            sfeed="Intermediate";
        }else{
            sfeed="Expert";
        }

        Score.setText(Integer.toString(x));
        Scorefeed.setText(sfeed);
        gamestop.setText(s);
    }

    public void PlayAgain(ActionEvent e)throws IOException{
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

    public void backhome(ActionEvent event)throws IOException{
        root= FXMLLoader.load(getClass().getResource("login.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css=this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

}
