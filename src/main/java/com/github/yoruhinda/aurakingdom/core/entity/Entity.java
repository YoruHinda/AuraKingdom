package main.java.com.github.yoruhinda.aurakingdom.core.entity;

import java.awt.*;

public abstract class Entity {
    protected int x;
    protected int y;

    protected Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(){

    }

    public void render(Graphics graphics){

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
