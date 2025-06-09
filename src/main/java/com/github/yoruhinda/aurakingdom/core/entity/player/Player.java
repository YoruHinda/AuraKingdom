package main.java.com.github.yoruhinda.aurakingdom.core.entity.player;

import main.java.com.github.yoruhinda.aurakingdom.core.animation.Animation;
import main.java.com.github.yoruhinda.aurakingdom.core.entity.Entity;
import main.java.com.github.yoruhinda.aurakingdom.core.game.Game;
import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameWindow;
import main.java.com.github.yoruhinda.aurakingdom.core.handlers.KeyHandler;
import main.java.com.github.yoruhinda.aurakingdom.core.util.SpriteLoader;
import main.java.com.github.yoruhinda.aurakingdom.core.util.resourcedirectory.WarriorDirectory;

import java.awt.*;

public class Player extends Entity {
    private int player_heath = 100;
    private int player_damage = 1;
    private PlayerState playerState = PlayerState.IDLE;
    private boolean isJumping = false;
    private float velocityY = 0;
    private final int PLAYER_WIDTH = 64 * GameWindow.SCALE;
    private final int PLAYER_HEIGHT = 49 * GameWindow.SCALE;
    private final float JUMP_FORCE = -10f;
    private final float MAX_FALL_SPEED = 12;
    private final float GRAVITY = 0.5f;
    private int animationFrame = 0;
    private int animationMaxFrame = 0;
    private boolean animationlocked = false;
    private KeyHandler keyHandler;
    private Animation idle;
    private Animation walking;
    private Animation jump;
    private Animation dash;
    private Animation attack;
    private Animation crouch;
    private Animation animation;

    public Player(int x, int y, KeyHandler keyHandler) {
        super(x, y);
        this.keyHandler = keyHandler;
        idle = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.IDLE), 6);
        walking = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.RUN), 6);
        jump = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.JUMP), 6);
        crouch = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.CROUCH), 6);
        attack = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.ATTACK), 6);
        dash = new Animation(SpriteLoader.getWarriorSprite(WarriorDirectory.DASH), 6);
        animation = idle;
        animation.start();
    }

    @Override
    public void update() {
        animation.update();
        velocityY += GRAVITY;
        if(velocityY > MAX_FALL_SPEED){
            velocityY = MAX_FALL_SPEED;
        }
        this.y += velocityY;
        if(this.y >= 4* GameWindow.TILE_SIZE){
            this.y = 4* GameWindow.TILE_SIZE;
            velocityY = 0;
            isJumping = false;
        }
        if(animationlocked){
            animationFrame++;
            if(animationFrame >= animationMaxFrame){
                animationlocked = false;
                playerState = PlayerState.IDLE;
                animationFrame = 0;
            }
            return;
        }
        if(animation.isFinished()){
            animationlocked = false;
            playerState = PlayerState.IDLE;
        }
        move();
        jump();
        crouch();
        attack();
        dash();
        animations();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(animation.getCurrentSprite(), (int)this.getX(), (int)this.getY(), this.PLAYER_WIDTH, this.PLAYER_HEIGHT,  null);
        graphics.dispose();
    }

    private void animations(){
        switch(playerState) {
            case PlayerState.IDLE:
                animation = idle;
                break;
            case PlayerState.WALKING:
                animation = walking;
                break;
            case PlayerState.ATTACK:
                animation = attack;
                break;
            case PlayerState.JUMP:
                animation = jump;
                break;
            case PlayerState.DASH:
                animation = dash;
                break;
            case PlayerState.CROUCH:
                animation = crouch;
                break;
        }
    }

    private void move(){
        if(keyHandler.isRight()){
            this.x += 3;
            playerState = PlayerState.WALKING;
        }
    }

    private void attack(){
        if(keyHandler.isAttack() && !animationlocked){
            playerState = PlayerState.ATTACK;
            animationMaxFrame = animation.getTotalFrames();
            animationFrame = 0;
            animationlocked = true;
            animation.reset();
            animation.start();
        }
    }

    private void crouch(){
        if(keyHandler.isCrouch()){
            playerState = PlayerState.CROUCH;
            animationMaxFrame = animation.getTotalFrames();
            animationFrame = 0;
            animationlocked = true;
        }
    }

    private void dash(){
        if(keyHandler.isDash()){
            playerState = PlayerState.DASH;
            animationMaxFrame = animation.getTotalFrames();
            animationFrame = 0;
            animationlocked = true;
        }
    }

    private void jump(){
        if(!isJumping && keyHandler.isJump()){
            playerState = PlayerState.JUMP;
            animationMaxFrame = animation.getTotalFrames();
            animationFrame = 0;
            animationlocked = true;
            velocityY = this.JUMP_FORCE;
            isJumping = true;
        }
    }
}
