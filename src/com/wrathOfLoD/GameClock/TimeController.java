package com.wrathOfLoD.GameClock;

/**
 * Created by luluding on 4/9/16.
 */
public class TimeController {
    //Needs a reference to TimeModel
    private TimeModel timeModel = TimeModel.getInstance();

    private final int framesPerSec = 60;
    private final long tickLength = 1000/framesPerSec;

    public void tick(){
        long lastTime = System.currentTimeMillis();

        timeModel.tick();

        //System.out.println("TICK TICK!");

        long deltaTime = System.currentTimeMillis() - lastTime;
        //System.out.println("DELTA TIME: " + deltaTime);


        if(deltaTime < tickLength){
            long sleepTime = tickLength - deltaTime;
            //System.out.println("SLEEP TIME: " + sleepTime);

            try{
                Thread.sleep(sleepTime);
            }catch (Exception e){
                System.out.println("EXCEPTION ON TIME CONTROLLER");
            }
        }
    }

    public long getTickLength() {
        return tickLength;
    }

    public int getFramesPerSec() {
        return framesPerSec;
    }


}
