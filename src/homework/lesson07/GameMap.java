package homework.lesson07;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int PVE_GAME = 0;
    public static final int PVP_GAME = 1;

    GameMap() {
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println("mode: " + mode + " | fieldSizeX: " + fieldSizeX + " | fieldSizeY: " + fieldSizeY + " | winLength: " + winLength);
    }

}
