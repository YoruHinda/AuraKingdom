package com.github.yoruhinda.aurakingdom.core.game.window;


import com.github.yoruhinda.aurakingdom.core.handlers.KeyHandler;

import javax.swing.*;

public class GameWindow extends JFrame {
    public final static String GAME_NAME = "AuraKingdom";
    public final static int ORIGINAL_TILE_SIZE = 16;
    public final static int SCALE = 4;
    public final static int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    public final static int SCREEN_COLS = 16;
    public final static int SCREEN_ROWS = 8;
    public final static int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS;
    public final static int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS;

    public GameWindow(GamePanel gamePanel, KeyHandler keyHandler) {
        this.getContentPane().add(gamePanel);
        this.pack();
        this.addKeyListener(keyHandler);
        this.setTitle(GAME_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setVisible(true);
        this.setResizable(false);
    }
}