package com.wrathOfLoD.Models;

import com.wrathOfLoD.GameClock.TimeController;

/**
 * Created by luluding on 4/9/16.
 */
public class ModelEngine implements Runnable{

    private static ModelEngine instance = new ModelEngine();
    public static ModelEngine getInstance(){return instance;}

    private TimeController timeController;
    private boolean gamePaused;
    private Thread gameThread;

    public ModelEngine(){
        timeController = new TimeController();
        gamePaused = false;
        gameThread = null;
    }


    @Override
    public void run() {
        while (true){
            if(!gamePaused)
                timeController.tick();
        }
    }

    public void start(){
        gamePaused = false;
        if(gameThread == null){
            gameThread = new Thread(this);
            gameThread.start();
        }
    }


    public boolean getGameRunningStatus(){
        return this.gamePaused;
    }

    public void pauseGame(){
        this.gamePaused = true;
    }

    public void resumeGame(){
        this.gamePaused = false;
    }

}
