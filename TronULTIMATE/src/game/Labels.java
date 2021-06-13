package game;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Labels {
    public Label player1Label = new Label();
    public Label player2Label = new Label();
    public Label player1Score = new Label();
    public Label player2Score = new Label();
    public Label redPlayer = new Label();
    public Label greenPlayer = new Label();
    public Label draw = new Label();
    private PlayerInterface player1;
    private PlayerInterface player2;
    Labels(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        player1Label.setText("Player:");
        player1Label.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 20));
        player1Label.setTextFill(Color.RED);
        player2Label.setText("Player:");
        player2Label.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 20));
        player2Label.setTextFill(Color.GREEN);

        player1Score.setText(Integer.toString(this.player1.getScore()));
        player1Score.setTextFill(Color.RED);
        player1Score.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 20));
        player2Score.setText(Integer.toString(this.player2.getScore()));
        player2Score.setTextFill(Color.GREEN);
        player2Score.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 20));

        redPlayer.setTextFill(Color.RED);
        redPlayer.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
        greenPlayer.setTextFill(Color.GREEN);
        greenPlayer.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
        draw.setTextFill(Color.AQUAMARINE);
        draw.setFont(Font.loadFont("file:src/fonts/Flynn.otf", 40));
    }
}
