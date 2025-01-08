package main.java.com.github.yoruhinda.aurakingdom.core.game.gameloop;

import main.java.com.github.yoruhinda.aurakingdom.core.game.window.GameScreen;

public class Game extends Thread{
    private boolean running;
    private GameScreen gameScreen;

    public Game(){
        this.gameScreen = new GameScreen();
        this.start();
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
