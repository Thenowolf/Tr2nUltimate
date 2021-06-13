package game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class GameTable {
    public final int SIRKA = 600;
    public final int VYSKA = 600;

    private GraphicsContext context;
    private Image background;
    private ArrayList<PlayerInterface> players;
    private Label redPlayerScore, greenPlayerScore;
    //players = new ArrayList<Object>(myTempObject);


    private Output Output = new Output();

    GameTable(GraphicsContext context, ArrayList<PlayerInterface> players, Label redPlayerScore, Label greenPlayerScore) {
        this.context = context;
        this.players = players;
        this.background = new Image("file:src/imgs/background.jpg");
        this.redPlayerScore = redPlayerScore;
        this.greenPlayerScore = greenPlayerScore;
        this.context.setFont(new Font("Tr2n", 80));
    }

    public void update() {
        //context.drawImage(player1, players.get(0).getPosX(), players.get(0).getPosY(), 10, 10);
        context.setFill(Color.GREEN);
        context.fillRect(players.get(0).getPosX(), players.get(0).getPosY(), 10, 10);
        context.setFill(Color.RED);
        //context.drawImage(player2, players.get(1).getPosX(), players.get(1).getPosY(), 10, 10);
        context.fillRect(players.get(1).getPosX(), players.get(1).getPosY(), 10, 10);
    }

    public void updateScore() {
        redPlayerScore.setText(Integer.toString(players.get(1).getScore()));
        greenPlayerScore.setText(Integer.toString(players.get(0).getScore()));
    }

    public void updateWinner() {
        if (players.get(1).getWinner()) {
            //context.drawImage(redWin, 45, 200, 510, 67);
            //context.text
            context.setFill(Color.RED);
            context.fillText("RED WON!", 100, 200);
            Output.saveScore("RED");
        } else if (players.get(0).getWinner()) {
            //context.drawImage(greenWin ,45, 200, 510,67);
            context.setFill(Color.GREEN);
            context.fillText("GREEN WON!", 40, 200);
            Output.saveScore("GREEN");
        } else {
            //context.drawImage(draw, 45, 200, 510, 67);
            context.setFill(Color.AQUAMARINE);
            context.fillText("DRAW!", 180, 200);
            Output.saveScore("DRAW");
        }
    }

    public void Countdown(int count) {
        context.drawImage(background, 0, 0);
        if (count > 1) {
            //countdown.setText(Integer.toString(count));
            context.setFill(Color.AQUAMARINE);
            context.fillText(Integer.toString(count), 270, 200);
        }
        if(count == 1) {
                context.fillText(Integer.toString(count), 290, 200);
        }
         if(count == 0) {
            context.fillText("START!", 140, 200);
        }
    }
}
