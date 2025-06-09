package main.java.com.github.yoruhinda.aurakingdom.core.game;

import main.java.com.github.yoruhinda.aurakingdom.core.entity.player.Player;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GamePanel;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameWindow;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.KeyHandler;
import main.java.com.github.yoruhinda.aurakingdom.core.level.Level;

import java.awt.*;

public class Game extends Thread {
    private static final int FPS = 60;
    private static final int UPS = 60;
    private static final double TIMER_PER_FRAME = 1_000_000_000.0 / FPS;
    private static final double TIMER_PER_UPDATE = 1_000_000_000.0 / UPS;
    private boolean running;
    private boolean paused;
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private KeyHandler keyHandler;
    private Player player;
    private Level level;

    public Game() {
        this.level = new Level("level1");
        this.keyHandler = new KeyHandler();
        this.player = new Player(0, 4 * GameWindow.TILE_SIZE, this.keyHandler);
        this.gamePanel = new GamePanel(this);
        this.gameWindow = new GameWindow(gamePanel, this.keyHandler);
        this.running = true;
        this.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        long now;
        double deltaUpdate = 0;
        double deltaFrame = 0;
        int update = 0;
        int frames = 0;

        while (running) {
            now = System.nanoTime();
            deltaUpdate += ((now - lastTime) / TIMER_PER_UPDATE);
            deltaFrame += ((now - lastTime) / TIMER_PER_FRAME);
            lastTime = now;

            if (deltaUpdate >= 1) {
                update();
                update++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                this.gameWindow.repaint();
                frames++;
                deltaFrame--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + ", UPS: " + update);
                frames = 0;
                update = 0;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update() {
        this.player.update();
    }

    public void render(Graphics graphics) {
        this.level.render(graphics);
        this.player.render(graphics);
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
