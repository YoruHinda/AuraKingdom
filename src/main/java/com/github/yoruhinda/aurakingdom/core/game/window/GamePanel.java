package com.github.yoruhinda.aurakingdom.core.game.window;

import com.github.yoruhinda.aurakingdom.core.game.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game){
        this.game = game;
        this.setPreferredSize(new Dimension(GameWindow.SCREEN_WIDTH, GameWindow.SCREEN_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        game.render(g);
    }
}
