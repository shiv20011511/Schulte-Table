package org.example.schultetable;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class abouthustler {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void backtologinAH(ActionEvent e)throws IOException {
        root= FXMLLoader.load(getClass().getResource("login.fxml"));
        stage =(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        String css=this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

}
