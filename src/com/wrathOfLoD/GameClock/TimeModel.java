package com.wrathOfLoD.GameClock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by luluding on 4/9/16.
 */
public class TimeModel {
    //TODO: have alertable to remove Model side code duplication

    private List<Tickable> tickableList;
    private ConcurrentHashMap<Fuseable, Integer> fuseableList;

    private static TimeModel instance = new TimeModel();
    public static TimeModel getInstance() {
        return instance;
    }

    private TimeModel(){
        tickableList = Collections.synchronizedList(new CopyOnWriteArrayList<Tickable>());
        fuseableList = new ConcurrentHashMap<>();
    }

    public void tick(){
        Iterator<Tickable> tickableIterator = tickableList.iterator();
        while(tickableIterator.hasNext()){
            tickableIterator.next().tick();
        }

        Iterator<Map.Entry<Fuseable, Integer>> fuseableIterator = this.fuseableList.entrySet().iterator();
        while(fuseableIterator.hasNext()){
            Map.Entry<Fuseable, Integer> entry = fuseableIterator.next();
            System.out.print("FUSEABLEEE: " + entry.getKey() + " .... " + entry.getValue());
            if(entry.getValue() <= 0){
                deregisterFuseable(entry.getKey());
                entry.getKey().explode();
            }
        }

    }

    public void registerTickable(Tickable tickable){
        this.tickableList.add(tickable);
    }

    public void deregisterTickable(Tickable tickable){
        this.tickableList.remove(tickable);
    }

    public void registerFuseable(Fuseable fuseable, int ticks){
        this.fuseableList.put(fuseable, ticks);
        System.out.println("REGISTER FUSEABLE???");
    }

    private void deregisterFuseable(Fuseable fuseable){
        this.fuseableList.remove(fuseable);
        System.out.println("DEREG FUSEABLE????????");
    }


}
