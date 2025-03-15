package main.java.com.github.yoruhinda.aurakingdom.core.game.window;

import main.java.com.github.yoruhinda.aurakingdom.core.game.gameloop.Game;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    private Game game;
    public final static String GAME_NAME = "AuraKingdom";
    public final static int ORIGINAL_TILE_SIZE = 16;
    public final static int SCALE = 2;
    public final static int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 32px
    public final static int SCREEN_COLS = 40;
    public final static int SCREEN_ROWS = 23;
    public final static int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS; // 1280px
    public final static int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS; // 736px

    public GameScreen(Game game){
        this.setTitle(GAME_NAME);
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setVisible(true);
        this.game = game;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.game.render(g);
    }
}