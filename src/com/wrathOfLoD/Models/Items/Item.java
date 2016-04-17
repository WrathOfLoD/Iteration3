package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Observers.ModelObservers.MapItemObservable;
import com.wrathOfLoD.Observers.ModelObservers.MapItemObserver;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

import java.util.ArrayList;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Item implements MapItemObservable{
    private String name;
    private int value = 10;
    private ArrayList<MapItemObserver> mapItemObservers;

    public Item(String name){
        this.name = name;
        mapItemObservers = new ArrayList<>();
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
    public void registerObserver(MapItemObserver mio) {
        mapItemObservers.add(mio);
    }

    @Override
    public void deregisterObserver(MapItemObserver mio) {
        mapItemObservers.remove(mio);
    }

    public ArrayList<MapItemObserver> getMapItemObservers(){
        return this.mapItemObservers;
    }
}
