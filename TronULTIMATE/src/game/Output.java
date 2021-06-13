package game;

import javafx.scene.control.Label;

import java.io.*;

public class Output {
    private PrintWriter printWriter = null;
    private BufferedReader bufferedReader = null;
    private int redCount = 0;
    private int greenCount = 0;
    private int drawCount = 0;

    public void saveScore(String Winner) {
        try {
            printWriter = new PrintWriter(new FileWriter("src/score/score.txt", true));
            printWriter.append("Winner: " + Winner + "\n");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Chyba při zápisu souboru.");
        }
    }

    public void getScore(Label red, Label green, Label draw) throws IOException {
        try {
            redCount = 0;
            greenCount = 0;
            drawCount = 0;
            bufferedReader = new BufferedReader(new FileReader("src/score/score.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("RED")) {
                    redCount++;
                    continue;
                }
                if (line.contains("GREEN")) {
                    greenCount++;
                    continue;
                }
                if (line.contains("DRAW")) {
                    drawCount++;
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chyba při čtení souboru!");
        }

        red.setText("Red: " + Integer.toString(redCount));
        green.setText("Green: " + Integer.toString(greenCount));
        draw.setText("Draw: " + Integer.toString(drawCount));
    }
}
