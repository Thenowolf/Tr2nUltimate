package game;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Panes {
    public BorderPane MainMenu = new BorderPane();
    public Pane gamePane = new Pane();
    public BorderPane wholeWindow = new BorderPane();
    public BorderPane ScoreMenu = new BorderPane();
    public Canvas canvas = new Canvas(Main.SIRKA, Main.VYSKA);
    Panes(Boxes boxes, BackgroundImage bg)
    {
        MainMenu.setCenter(boxes.Vbox);
        MainMenu.setBackground(new Background(bg));
        gamePane.getChildren().add(canvas);
        wholeWindow.setBottom(gamePane);
        wholeWindow.setTop(boxes.Hbox);
        wholeWindow.setStyle("-fx-background-color: black;");
        ScoreMenu.setBackground(new Background(bg));
        ScoreMenu.setCenter(boxes.Vbox2);
    }

}
