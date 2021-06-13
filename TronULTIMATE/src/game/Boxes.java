package game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Boxes {
    public VBox Vbox = new VBox();
    public VBox Vbox2 = new VBox();
    public HBox Hbox = new HBox();
    Boxes(Buttons buttons, Labels labels)
    {
        Vbox.getChildren().add(buttons.startbutt);
        Vbox.getChildren().add(buttons.scorebutt);
        Vbox.getChildren().add(buttons.exitbutt);
        Vbox.setPadding(new Insets(10,10,100,10));
        Vbox.setAlignment((Pos.BOTTOM_CENTER));
        Vbox.setSpacing(5);

        Hbox.setAlignment(Pos.CENTER);
        Hbox.setSpacing(10);
        Hbox.getChildren().add(labels.player1Label);
        Hbox.getChildren().add(labels.player1Score);
        Hbox.getChildren().add(buttons.restartbutt);
        Hbox.getChildren().add(labels.player2Label);
        Hbox.getChildren().add(labels.player2Score);

        Vbox2.setPadding(new Insets(10,10,100,10));
        Vbox2.setAlignment(Pos.BOTTOM_CENTER);
        Vbox2.setSpacing(20);
        Vbox2.getChildren().add(labels.redPlayer);
        Vbox2.getChildren().add(labels.greenPlayer);
        Vbox2.getChildren().add(labels.draw);
        Vbox2.getChildren().add(buttons.returnbutt);

    }
}
