package main.java.com.github.yoruhinda.aurakingdom.core.game.window;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private final static String GAME_NAME = "AuraKingdom";
    public GameFrame(){
        this.setTitle(GAME_NAME);
        this.setSize(640,480);
        this.getContentPane().setBackground(Color.darkGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}