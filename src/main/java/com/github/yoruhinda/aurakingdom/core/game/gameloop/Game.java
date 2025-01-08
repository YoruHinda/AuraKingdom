package main.java.com.github.yoruhinda.aurakingdom.core.game.gameloop;

import main.java.com.github.yoruhinda.aurakingdom.core.entity.player.Player;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameScreen;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.move.KeyMovementEvent;

import java.awt.*;

public class Game extends Thread{
    private boolean running;
    private final GameScreen gameScreen;
    private KeyMovementEvent keyMovementEvent;
    private Player player;

    public Game(){
        this.gameScreen = new GameScreen();
        this.keyMovementEvent = new KeyMovementEvent();
        this.gameScreen.addKeyListener(this.keyMovementEvent);
        this.running = true;
        this.start();
    }

    @Override
    public void run() {
        while(running){
            update();
            render(this.gameScreen.getGraphics());
            this.gameScreen.repaint();
        }
    }

    private void update(){
        this.player.update();
    }

    private void render(Graphics graphics){
        this.player.render(graphics);
    }

    public boolean isRunning(){
        return this.running;
    }

    public void setRunning(boolean running){
        this.running = running;
    }
}
