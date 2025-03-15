package main.java.com.github.yoruhinda.aurakingdom.core.entity.player;

import main.java.com.github.yoruhinda.aurakingdom.core.entity.Entity;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameScreen;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.move.KeyMovementEvent;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteLoader;

import java.awt.*;

public class Player extends Entity {
    private KeyMovementEvent keyMovementEvent;
    public Player(int x, int y, KeyMovementEvent keyMovementEvent) {
        super(x, y);
        this.keyMovementEvent = keyMovementEvent;
    }

    @Override
    public void update() {
        if(keyMovementEvent.isLeft()) this.x -= 2;
        if(keyMovementEvent.isRight()) this.x += 2;
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(SpriteLoader.getWarriorSprite("Warrior/idle").getFirst(), this.getX(), this.getY(), null);
        graphics2D.dispose();
    }
}
