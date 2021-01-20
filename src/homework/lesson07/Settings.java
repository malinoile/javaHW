package homework.lesson07;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 12;
    private static final int MIN_WIN_STRIKE = 3;

    private static final String PREFIX_FIELD_SIZE = "Размер поля: ";
    private static final String PREFIX_WIN_STRIKE = "Выигрышная позиция: ";

    private JRadioButton radioPvE;
    private JRadioButton radioPvP;
    private JSlider sliderFieldSize;
    private JSlider sliderWinStrike;

    private MainWindow mainWindow;

    Settings(MainWindow mainWindow) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.mainWindow = mainWindow;
        setLocation((int)(mainWindow.getLocation().x + (mainWindow.getBounds().getWidth() - WINDOW_WIDTH) / 2),
                    (int)(mainWindow.getLocation().y + (mainWindow.getBounds().getHeight() - WINDOW_HEIGHT) / 2));
        setTitle("Настройки игры");

        setLayout(new GridLayout(9, 1));

        add(new JLabel("Выберите режим игры:"));
        addGameMode();
        add(new JLabel("Укажите параметры игры:"));
        addFieldSize();
        JButton startButton = new JButton("Start game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartGame();
            }
        });
        add(startButton);
    }

    private void addGameMode() {
        ButtonGroup groupMode = new ButtonGroup();
        radioPvE = new JRadioButton("Игрок vs. PC", true);
        radioPvP = new JRadioButton("Игрок vs. Игрок");
        groupMode.add(radioPvE);
        groupMode.add(radioPvP);
        add(radioPvE);
        add(radioPvP);
    }

    private void addFieldSize() {
        JLabel lbFieldSize = new JLabel(PREFIX_FIELD_SIZE + MIN_FIELD_SIZE);
        JLabel lbWinStrike = new JLabel(PREFIX_WIN_STRIKE + MIN_WIN_STRIKE);

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinStrike = new JSlider(MIN_WIN_STRIKE, MIN_FIELD_SIZE, MIN_WIN_STRIKE);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinStrike.setMaximum(sliderFieldSize.getValue());
                lbFieldSize.setText(PREFIX_FIELD_SIZE + sliderFieldSize.getValue());
            }
        });

        sliderWinStrike.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinStrike.setText(PREFIX_WIN_STRIKE + sliderWinStrike.getValue());
            }
        });

        add(lbFieldSize);
        add(sliderFieldSize);
        add(lbWinStrike);
        add(sliderWinStrike);
    }

    private void btnStartGame() {
        int gamemode;

        if(radioPvE.isSelected()) {
            gamemode = GameMap.PVE_GAME;
        } else if(radioPvP.isSelected()) {
            gamemode = GameMap.PVP_GAME;
        } else {
            throw new RuntimeException("Неизвестный режим игры");
        }

        mainWindow.startGame(gamemode, sliderFieldSize.getValue(), sliderFieldSize.getValue(), sliderWinStrike.getValue());
        setVisible(false);
    }

}
