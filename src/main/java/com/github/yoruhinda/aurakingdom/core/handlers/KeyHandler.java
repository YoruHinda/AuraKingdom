package com.github.yoruhinda.aurakingdom.core.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean right, left, jump, dash, crouch, attack;
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_RIGHT -> right = true;
            case KeyEvent.VK_LEFT -> left = true;
            case KeyEvent.VK_UP -> jump = true;
            case KeyEvent.VK_DOWN -> crouch = true;
            case KeyEvent.VK_A -> attack = true;
            case KeyEvent.VK_SHIFT -> dash = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_RIGHT -> right = false;
            case KeyEvent.VK_LEFT -> left = false;
            case KeyEvent.VK_UP -> jump = false;
            case KeyEvent.VK_DOWN -> crouch = false;
            case KeyEvent.VK_A -> attack = false;
            case KeyEvent.VK_SHIFT -> dash = false;
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isDash() {
        return dash;
    }

    public boolean isAttack() {
        return attack;
    }

    public boolean isCrouch() {
        return crouch;
    }
}
