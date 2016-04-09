package com.wrathOfLoD.GameClock;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by luluding on 4/9/16.
 */
public class TimeModel {
    private List<Tickable> tickableList;

    private static TimeModel instance = new TimeModel();
    public static TimeModel getInstance() {
        return instance;
    }

    private TimeModel(){
        tickableList = Collections.synchronizedList(new CopyOnWriteArrayList<Tickable>());
    }

    public void tick(){
        Iterator<Tickable> tickableIterator = tickableList.iterator();
        while(tickableIterator.hasNext()){
            tickableIterator.next().tick();
        }
    }

    public void registerTickable(Tickable tickable){
        this.tickableList.add(tickable);
    }

    public void removeTickable(Tickable tickable){
        this.tickableList.remove(tickable);
    }


}
