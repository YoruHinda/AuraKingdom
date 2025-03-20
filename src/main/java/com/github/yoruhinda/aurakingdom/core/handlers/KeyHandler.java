package main.java.com.github.yoruhinda.aurakingdom.core.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private boolean right, left;
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_D -> right = true;
            case KeyEvent.VK_A -> left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_D -> right = false;
            case KeyEvent.VK_A -> left = false;
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }
}
