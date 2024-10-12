package org.example.schultetable;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Random;

//this is hard

public class GameareaController {



    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12,
            bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23,
            bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35, bt36, ready, back;
    @FXML
    private Timeline timeline;
    @FXML
    private Label timerLabel;

    private int expectednumber = 1;
    private List<Button> buttons;
    private Random random = new Random();
    private int secondsRemaining = 60;


    @FXML
    private void setTextAndColorOnButtons(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();

        if (buttonText.equals(String.valueOf(expectednumber))) {
            expectednumber++;
        } else {
            String s="Your Game Interrupted Due To Sequence Missed "+expectednumber;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scorecard.fxml"));
            root = loader.load();
            scorecardController scorecardController = loader.getController();
            scorecardController.displayScore(expectednumber - 1,s);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = this.getClass().getResource("login.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
            ready.setVisible(false);
            back.setVisible(false);
        }

        List<Integer> numbers = generateUniqueNumbers(1, 36);
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            int randomIndex = random.nextInt(numbers.size());
            int randomText = numbers.get(randomIndex);
            numbers.remove(randomIndex);
            button.setText(String.valueOf(randomText));
            Color randomColor = generateRandomColor();
            button.setTextFill(randomColor);
            button.setStyle("-fx-background-color: " + colorToHex(randomColor) + "; -fx-text-fill: black;");
        }
    }

    private List<Integer> generateUniqueNumbers(int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private Color generateRandomColor() {
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private String colorToHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 200),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    @FXML
    public void changeButtonText(ActionEvent e) throws Exception {
        startTimer();

        for (int i = 0; i < 36; i++) {
            Button button = buttons.get(i);
            button.setText(String.valueOf(i + 1));
            button.setTextFill(Color.RED);
            button.setStyle("-fx-background-color: orange; -fx-text-fill: black;");
        }

        ready.setVisible(false);
        back.setVisible(false);

    }




    @FXML
    public void initialize() {
        buttons = List.of(bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12,
                bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23,
                bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35, bt36);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimerLabel()));
        timeline.setCycleCount(Animation.INDEFINITE);
        this.stage=stage;
    }

    public void backtomain(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    private void startTimer() {
        timeline.play();
    }

    private void updateTimerLabel() {
        timerLabel.setText("Timer: " + secondsRemaining + "s");
        secondsRemaining--;

        if (secondsRemaining == 0) {
            timeline.stop();
            timerLabel.setText("Timer: Time's up!");
            DisplayScoreTimeUP();
        }
    }

    public void DisplayScoreTimeUP() {
        try {
            String s="You Ran Out Of Time ";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scorecard.fxml"));
            root = loader.load();
            scorecardController scorecardController = loader.getController();
            scorecardController.displayScore(expectednumber - 1,s);
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("login.css").toExternalForm();

            stage = (Stage) timerLabel.getScene().getWindow();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
