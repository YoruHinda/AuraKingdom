package main.java.com.github.yoruhinda.aurakingdom.core.animation;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
    private int frameCount;
    private int currentFrame;
    private int frameDelay;
    private int animationDirection;
    private int totalFrames;

    private boolean stopped;

    private List<BufferedImage> frames;

    public Animation(List<BufferedImage> frames, int delay) {
        this.stopped = true;
        this.frameDelay = delay;
        this.frames = frames;

        this.animationDirection = 1;
        this.frameCount = 0;
        this.totalFrames = frames.size();
    }

    public void start(){
        if(!stopped) return;
        if(frames.isEmpty()) return;
        this.stopped = false;
    }

    public void restart(){
        if(frames.isEmpty()) return;
        this.stopped = false;
        this.currentFrame = 0;
    }

    public void stop(){
        if(frames.isEmpty()) return;
        this.stopped = true;
    }

    public void reset(){
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    public BufferedImage getCurrentSprite(){
        return this.frames.get(this.currentFrame);
    }

    public void update(){
        if(!stopped){
            frameCount++;
            if(frameCount > frameDelay){
                frameCount = 0;
                currentFrame += animationDirection;
                if(currentFrame > totalFrames - 1){
                    currentFrame = 0;
                }
            }
        }
    }
}
