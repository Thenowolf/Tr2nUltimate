package game;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Buttons {
    /* Tlačítka */
    public Button startbutt = new Button();
    public Button scorebutt = new Button();
    public Button exitbutt = new Button();
    public Button restartbutt = new Button();
    public Button returnbutt = new Button();
    Buttons()
    {
        /* Start tlačítko
         */
        startbutt.setText("Start game");
        startbutt.setTextFill(Color.AQUA);
        startbutt.setStyle("-fx-background-color:transparent");
        startbutt.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
        /* Skóre tlačítko
         */
        scorebutt.setText("Score");
        scorebutt.setTextFill(Color.AQUA);
        scorebutt.setStyle("-fx-background-color:transparent");
        scorebutt.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
        /* Ukončit tlačítko
         */
        exitbutt.setText("Exit game");
        exitbutt.setTextFill(Color.AQUA);
        exitbutt.setStyle("-fx-background-color:transparent");
        exitbutt.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
        /*  Vrátit zpět tlačítko
         */
        returnbutt.setText("Return");
        returnbutt.setTextFill(Color.BLACK);
        returnbutt.setStyle("-fx-background-color:transparent");
        returnbutt.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
        /* Restartovat hru tlačítko
         */
        restartbutt.setText("Restart");
        restartbutt.setStyle("-fx-background-color: transparent");
        restartbutt.setTextFill(Color.WHITE);
        restartbutt.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 20));
    }
}
