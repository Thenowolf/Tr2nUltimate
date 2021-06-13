package game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    /* Statické proměnné pro ŠÍŘKU a VÝŠKU */
    public static final int SIRKA = 600;
    public static final int VYSKA = 600;
    private BackgroundImage bg = new BackgroundImage(new Image("file:src/imgs/tronbg.png",600,610,false, true),BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    //private GameInfo Info;
    private Controller Controller;
    private GameTable gameTable;
    private Control Control;
    private Output Output = new Output();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerInterface> playersint = new ArrayList<>();
    private Buttons buttons = new Buttons();
    private Player player1 = new Player((SIRKA/2)+150, VYSKA/2, 10);
    private Player player2 = new Player((SIRKA/2)-150, VYSKA/2, 10);
    private Labels labels = new Labels(player1,player2);
    private Boxes boxes = new Boxes(buttons,labels);
    private Panes panes = new Panes(boxes, bg);
    private Scene MainMenuScene = new Scene(panes.MainMenu, SIRKA, VYSKA);
    private Scene gameScene = new Scene(panes.wholeWindow, SIRKA, VYSKA+60);
    private Scene scoreScene = new Scene(panes.ScoreMenu,SIRKA,VYSKA);


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TRON ULTIMATE");
        /* Pridání do ArrayListu a započati pohybu */
        players.add(player1);
        players.add(player2);
        playersint.add(player1);
        playersint.add(player2);
        players.get(0).MoveLEFT();
        players.get(1).MoveRIGHT();
        /* pomocné objekty */
        gameTable = new GameTable(panes.canvas.getGraphicsContext2D(),playersint, labels.player1Score,labels.player2Score);
        Controller = new Controller(gameTable,players);
        Control = new Control(Controller,gameScene,players);

        /* Funkce tlačítek */
        buttons.startbutt.setOnAction(actionEvent ->
        {
            primaryStage.setScene(gameScene);
            Controller.start();
        });

        buttons.scorebutt.setOnAction(actionEvent->{
            try {
                Output.getScore(labels.redPlayer,labels.greenPlayer, labels.draw);
            } catch (IOException e) {
                System.out.println("Chyba cteni souboru!");
                System.exit(0);
            }
            primaryStage.setScene( scoreScene );
            primaryStage.show();
        });

        buttons.exitbutt.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        buttons.restartbutt.setOnAction(actionEvent->{
            Controller.restart();
        });

        buttons.returnbutt.setOnAction(actionEvent->{
            primaryStage.setScene( MainMenuScene );
            primaryStage.show();
        });

        primaryStage.setScene(MainMenuScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
