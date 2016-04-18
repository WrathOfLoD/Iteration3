package com.wrathOfLoD.Models.RangedEffect.HitBox;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxEffects.HitBoxEffect;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObservable;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObserver;
import com.wrathOfLoD.Utility.Position;
import sun.security.krb5.internal.crypto.Des;

import java.util.*;

/**
 * Created by luluding on 4/9/16.
 */
public class HitBox implements DestroyableModelObservable{
    private int power;
    private int accuracy;
    private String name;
    private Position location;
    private HitBoxEffect hitBoxEffect;
    private ArrayList<DestroyableModelObserver> destroyableModelObservers;

    public HitBox(int power, int accuracy, String name, Position location, HitBoxEffect hitBoxEffect){
        this.power = power;
        this.accuracy = accuracy;
        this.name = name;
        this.location = location;
        this.hitBoxEffect = hitBoxEffect;
        this.destroyableModelObservers = new ArrayList<>();
    }

    //depends on accuacy
    private boolean shouldDoEffect(){
        int randomNum = (int)(Math.random() * 100) + 1; //generate a randomNum from 1 to 100 (max accu percent)
        if(randomNum <= accuracy)
            return true;

        return false;
    }

    public void apply(){
        List<Entity> entities = Map.getInstance().getTile(location).getEntitiesList();
        if(shouldDoEffect()){
            hitBoxEffect.doEffect(entities);
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void registerObserver(DestroyableModelObserver mio) {
        destroyableModelObservers.add(mio);
    }

    @Override
    public void deregisterObserver(DestroyableModelObserver mio) {
        destroyableModelObservers.remove(mio);
    }

    public void destroyHitbox(){
        Iterator<DestroyableModelObserver> observerIterator = destroyableModelObservers.iterator();
        while(observerIterator.hasNext()){
            observerIterator.next().notifyDestroy(location);
            observerIterator.remove();
        }
    }
}
