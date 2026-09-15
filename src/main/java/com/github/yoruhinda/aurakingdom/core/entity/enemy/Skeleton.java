package com.github.yoruhinda.aurakingdom.core.entity.enemy;

import com.github.yoruhinda.aurakingdom.core.animation.Animation;
import com.github.yoruhinda.aurakingdom.core.entity.Entity;
import com.github.yoruhinda.aurakingdom.core.entity.player.Player;

import java.awt.*;

public class Skeleton extends Entity {
    private Player player;
    private Animation idle;
    private Animation attack;
    private Animation hit;
    private Animation walk;
    private Animation dead;
    private Animation react;
    private Animation animation;
    protected Skeleton(int x, int y, Player player) {
        super(x, y);
        this.player = player;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics graphics) {
    }
}
