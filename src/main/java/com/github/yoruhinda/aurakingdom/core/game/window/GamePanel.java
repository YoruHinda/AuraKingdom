package main.java.com.github.yoruhinda.aurakingdom.core.game.window;

import main.java.com.github.yoruhinda.aurakingdom.core.game.gameloop.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game){
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        game.render(g);
    }
}
