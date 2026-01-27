package com.github.yoruhinda.aurakingdom.core.entity;

import java.awt.*;

public abstract class Entity {
    protected float x;
    protected float y;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(){

    }

    public void render(Graphics graphics){

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
