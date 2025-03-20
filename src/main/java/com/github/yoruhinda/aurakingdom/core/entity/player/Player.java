package main.java.com.github.yoruhinda.aurakingdom.core.entity.player;

import main.java.com.github.yoruhinda.aurakingdom.core.animation.Animation;
import main.java.com.github.yoruhinda.aurakingdom.core.entity.Entity;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameWindow;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.KeyHandler;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteLoader;
import main.java.com.github.yoruhinda.aurakingdom.core.util.resourcedirectory.WarriorDirectory;

import java.awt.*;

public class Player extends Entity {
    private final int PLAYER_WIDTH = 64 * GameWindow.SCALE;
    private final int PLAYER_HEIGHT = 49 * GameWindow.SCALE;
    private KeyHandler keyHandler;
    private Animation idle;
    private Animation walking;
    private Animation animation;

    public Player(int x, int y, KeyHandler keyHandler) {
        super(x, y);
        this.keyHandler = keyHandler;
        idle = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.IDLE), 6);
        walking = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.RUN), 6);
        animation = idle;
        animation.start();
    }

    @Override
    public void update() {
        animation.update();
        playerMovementUpdater();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(animation.getCurrentSprite(), this.getX(), this.getY(), this.PLAYER_WIDTH, this.PLAYER_HEIGHT,  null);
        graphics.dispose();
    }

    public void playerMovementUpdater(){
        if (!keyHandler.isRight() && !keyHandler.isLeft()) {
            animation = idle;
            animation.start();
        }
        if(keyHandler.isLeft())this.x -= 3;
        if(keyHandler.isRight()){
            this.x += 3;
            this.animation.stop();
            this.animation = walking;
            this.animation.start();
        }
    }
}
