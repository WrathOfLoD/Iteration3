package com.wrathOfLoD.Observers.ModelObservers;

/**
 * Created by luluding on 4/16/16.
 */
public interface MapObservable {
    public void registerObserver(MapObserver mo);
    public void deregisterObserver(MapObserver mo);
}
