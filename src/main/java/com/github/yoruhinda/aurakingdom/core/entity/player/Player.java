package main.java.com.github.yoruhinda.aurakingdom.core.entity.player;

import main.java.com.github.yoruhinda.aurakingdom.core.entity.Entity;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.move.KeyMovementEvent;

import java.awt.*;

public class Player extends Entity {
    private KeyMovementEvent keyMovementEvent;
    public Player(float x, float y, KeyMovementEvent keyMovementEvent) {
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
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect((int) this.x,(int)this.y, 64, 44);
        graphics2D.dispose();
    }
}
