package main.java.com.github.yoruhinda.aurakingdom.core.game.gameloop;

import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameFrame;

public class Game extends Thread{
    private boolean running;
    public Game(){
        new GameFrame();
    }

    @Override
    public void run() {
        while(running){
            update();
            render();
        }
    }

    private void update(){

    }

    private void render(){

    }
}
