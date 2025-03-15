package main.java.com.github.yoruhinda.aurakingdom.core.entity.player;

import main.java.com.github.yoruhinda.aurakingdom.core.animation.Animation;
import main.java.com.github.yoruhinda.aurakingdom.core.entity.Entity;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.move.KeyMovementEvent;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteLoader;
import main.java.com.github.yoruhinda.aurakingdom.core.util.resourcedirectory.WarriorDirectory;

import java.awt.*;

public class Player extends Entity {
    private KeyMovementEvent keyMovementEvent;
    private Animation idle;
    private Animation animation;
    public Player(int x, int y, KeyMovementEvent keyMovementEvent) {
        super(x, y);
        this.keyMovementEvent = keyMovementEvent;
        idle = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.IDLE), 10);
        animation = idle;
        animation.start();
    }

    @Override
    public void update() {
        animation.update();
        if(keyMovementEvent.isLeft()) this.x -= 2;
        if(keyMovementEvent.isRight()) this.x += 2;
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(animation.getCurrentSprite(), this.getX(), this.getY(), null);
        graphics2D.dispose();
    }
}
