package com.github.yoruhinda.aurakingdom.core.entity.enemy;

import com.github.yoruhinda.aurakingdom.core.animation.Animation;
import com.github.yoruhinda.aurakingdom.core.entity.Entity;

import java.awt.*;

public class Skeleton extends Entity {
    private Animation idle;
    private Animation attack;
    private Animation hit;
    private Animation walk;
    private Animation dead;
    private Animation react;
    private Animation animation;
    protected Skeleton(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics graphics) {
    }
}
