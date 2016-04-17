package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObservable;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObserver;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

import java.util.ArrayList;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Item implements DestroyableModelObservable {
    private String name;
    private int value = 10;
    private ArrayList<DestroyableModelObserver> destroyableModelObservers;

    public Item(String name){
        this.name = name;
        destroyableModelObservers = new ArrayList<>();
    }

    /***** getter & setter for Item *******/

    public String getName(){return this.name;}

    public int getValue() {
        return value;
    }

    /********* END Getters and Setters *********/

    public abstract void encounter(Entity entity);

    public void accept(ItemVisitor iv){
        iv.visitItem(this);
    }

    @Override
    public void registerObserver(DestroyableModelObserver mio) {
        destroyableModelObservers.add(mio);
    }

    @Override
    public void deregisterObserver(DestroyableModelObserver mio) {
        destroyableModelObservers.remove(mio);
    }

    public ArrayList<DestroyableModelObserver> getDestroyableModelObservers(){
        return this.destroyableModelObservers;
    }
}
