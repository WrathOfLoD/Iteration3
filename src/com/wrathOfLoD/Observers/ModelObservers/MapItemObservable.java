package com.wrathOfLoD.Observers.ModelObservers;

/**
 * Created by luluding on 4/17/16.
 */
public interface MapItemObservable {
    public void registerObserver(MapItemObserver mio);
    public void deregisterObserver(MapItemObserver mio);
}
