package main.java.com.github.yoruhinda.aurakingdom.core.game.gameloop;

import main.java.com.github.yoruhinda.aurakingdom.core.entity.player.Player;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameScreen;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.move.KeyMovementEvent;

import java.awt.*;

public class Game extends Thread{
    private static final int FPS = 60;
    private static final double NS_PER_TICK = 1_000_000_000.0 / FPS;
    private boolean running;
    private final GameScreen gameScreen;
    private KeyMovementEvent keyMovementEvent;
    private Player player;

    public Game(){
        this.gameScreen = new GameScreen(this);
        this.keyMovementEvent = new KeyMovementEvent();
        this.gameScreen.addKeyListener(this.keyMovementEvent);
        this.player = new Player(0,500, this.keyMovementEvent);
        this.running = true;
        this.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;

        while(running){
            long now = System.nanoTime();
            unprocessedTime += ((now - lastTime) / NS_PER_TICK);
            lastTime = now;
            while(unprocessedTime >= 1){
                update();
                unprocessedTime --;
            }
            this.gameScreen.repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(){
        this.player.update();
    }

    public void render(Graphics graphics){
        this.player.render(graphics);
    }

    public boolean isRunning(){
        return this.running;
    }

    public void setRunning(boolean running){
        this.running = running;
    }
}
