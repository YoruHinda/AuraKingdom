package main.java.com.github.yoruhinda.aurakingdom.core.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean right, left, jump, dash, crouch, run, attack;
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_RIGHT -> right = true;
            case KeyEvent.VK_LEFT -> left = true;
            case KeyEvent.VK_SHIFT -> run = true;
            case KeyEvent.VK_SPACE -> jump = true;
            case KeyEvent.VK_DOWN -> crouch = true;
            case KeyEvent.VK_A -> attack = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_RIGHT -> right = false;
            case KeyEvent.VK_LEFT -> left = false;
            case KeyEvent.VK_SHIFT -> run = false;
            case KeyEvent.VK_SPACE -> jump = false;
            case KeyEvent.VK_DOWN -> crouch = false;
            case KeyEvent.VK_A -> attack = false;
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

    public boolean isRun() {
        return run;
    }
}
