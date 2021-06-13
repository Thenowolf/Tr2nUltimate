package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

import static game.Main.SIRKA;
import static game.Main.VYSKA;

public class Controller {

    private Timeline gameTimer;
    private Timeline countdownTimer;
    private GameTable gameInfo;
    private ArrayList<Player> players;
    private ArrayList<Point2D> Squares = new ArrayList<>();
    private int count = 4;
    private boolean gameOver = false;

    public Controller(GameTable gameInfo, ArrayList<Player> players)
    {
        this.gameInfo = gameInfo;
        this.players = players;
        gameTimer = new Timeline(new KeyFrame(Duration.millis(100), actionEvent ->
        {
            if(!this.players.get(0).IsInBounds(VYSKA, SIRKA))
            {
                this.players.get(0).PlayerCollision();
            }
            if(!this.players.get(1).IsInBounds(VYSKA,SIRKA))
            {
                this.players.get(1).PlayerCollision();
            }
            if(((this.players.get(0).getPosX()) == this.players.get(1).getPosX())&&(this.players.get(0).getPosY()==this.players.get(1).getPosY()))
            {
                this.players.get(0).PlayerCollision();
                this.players.get(1).PlayerCollision();
            }
            Iterator<Player> iterator = this.players.iterator();

            while(iterator.hasNext()){
                Player player = iterator.next();

                Iterator<Point2D> iteratorSquares = Squares.iterator();
                while(iteratorSquares.hasNext()){
                    Point2D point = iteratorSquares.next();
                    if((player.getPosY()==point.getY())&&(player.getPosX()==point.getX())){
                        player.PlayerCollision();
                    }
                }
                Squares.add(new Point2D(player.getPosX(),player.getPosY()));

                if(!player.IsAlive()){
                    gameOver = true;
                    updateScore();
                }
                else{
                    player.StartMove();
                }
            }
            if(gameOver){
                this.gameInfo.update();
                this.gameInfo.updateScore();
                this.gameInfo.updateWinner();
                gameTimer.stop();
            }
            this.gameInfo.update();
        }));
        gameTimer.setCycleCount(Timeline.INDEFINITE); // nastavení cyklu do nekonečna
        countdownTimer = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent ->
        {
            count--;
            gameInfo.Countdown(count);
        }));

        countdownTimer.setCycleCount(5);
       // this.gameInfo = gameInfo; // nevím?
       // this.players = players;


        countdownTimer.setOnFinished(e->
        {
            this.count = 4;
            gameTimer.play();
        });
    }
    public void start(){
        this.count = 4;
        countdownTimer.play();
    }
    public void restart(){
        gameTimer.stop();
        if((players.get(0).getScore()==3)||(players.get(1).getScore()==3))
        {
            players.get(0).ResetScore();
            players.get(1).ResetScore();
        }
        players.get(0).ResetPlayer();
        players.get(1).ResetPlayer();
        players.get(0).MoveLEFT();
        players.get(1).MoveRIGHT();
        this.gameOver = false;
        this.Squares.clear();
        countdownTimer.play();
    }
    public boolean isRunning(){
        return gameTimer.getStatus()==Timeline.Status.RUNNING;
    }
    public void updateScore(){
        //Player p1 = players.get(0);
        //Player p2 = players.get(1);
        if(players.get(0).IsAlive()&&!players.get(1).IsAlive())
        {
            players.get(0).AddWin();
        }
        if(!players.get(0).IsAlive()&&players.get(1).IsAlive())
        {
            players.get(1).AddWin();
        }
    }
}
