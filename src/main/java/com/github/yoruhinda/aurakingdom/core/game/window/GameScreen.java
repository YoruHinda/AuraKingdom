package main.java.com.github.yoruhinda.aurakingdom.core.game.window;

import javax.swing.*;

public class GameScreen extends JFrame {
    private final static String GAME_NAME = "AuraKingdom";
    private final static int ORIGINAL_TILE_SIZE = 16;
    private final static int SCALE = 2;
    private final static int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 32px
    private final static int SCREEN_COLS = 40;
    private final static int SCREEN_ROWS = 23;
    private final static int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS; // 1280px
    private final static int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS; // 736px

    public GameScreen(){
        this.setTitle(GAME_NAME);
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}