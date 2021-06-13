package game;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Control {
    private Controller Controller;
    private Scene Scene;
    //private Player player1;
    //private Player player2;
    private ArrayList<Player> players;
    Control(Controller Controller, Scene Scene, ArrayList players){
        /*
        Eventhandler - klávesy
         */
        this.Controller = Controller;
        this.Scene = Scene;
        this.players = players;
        //this.player1 = player1;
        //this.player2 = player2;

        this.Scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if (this.Controller.isRunning()){
                if(key.getCode() == KeyCode.NUMPAD8)
                {
                    this.players.get(0).MoveUP();
                }
                if(key.getCode() == KeyCode.NUMPAD5)
                {
                    this.players.get(0).MoveDOWN();
                }
                if(key.getCode() == KeyCode.NUMPAD6)
                {
                    this.players.get(0).MoveRIGHT();
                }
                if(key.getCode() == KeyCode.NUMPAD4)                      {
                    this.players.get(0).MoveLEFT();
                }
                if(key.getCode() == KeyCode.P)                      {
                   // this.player1.StopMove();
                   // this.player2.StopMove();
                }
            }
        });

        this.Scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if (this.Controller.isRunning()){
                if(key.getCode() == KeyCode.W)
                {
                    this.players.get(1).MoveUP();
                }
                if(key.getCode() == KeyCode.S)
                {
                    this.players.get(1).MoveDOWN();
                }
                if(key.getCode() == KeyCode.D)
                {
                    this.players.get(1).MoveRIGHT();
                }
                if(key.getCode() == KeyCode.A)                      {
                    this.players.get(1).MoveLEFT();
                }
            }
        });
    }
}
