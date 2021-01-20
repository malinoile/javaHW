package homework.lesson07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 450;
    private static final int WINDOW_POSITION_X = 450;
    private static final int WINDOW_POSITION_Y = 200;

    private Settings settings;
    private GameMap gameMap;

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSITION_X, WINDOW_POSITION_Y);
        setResizable(false);
        setTitle("Крестики-нолики");

        settings = new Settings(this);
        gameMap = new GameMap();

        JButton exitButton = new JButton("Exit game");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton startButton = new JButton("New game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panelButton = new JPanel(new GridLayout(1, 2));
        panelButton.add(startButton);
        panelButton.add(exitButton);

        add(panelButton, BorderLayout.SOUTH);
        add(gameMap, BorderLayout.CENTER);

        setVisible(true);
    }

    public void startGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
