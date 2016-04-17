package com.wrathOfLoD.Observers.ModelObservers;

/**
 * Created by luluding on 4/17/16.
 */
public interface DestroyableModelObservable {
    public void registerObserver(DestroyableModelObserver mio);
    public void deregisterObserver(DestroyableModelObserver mio);
}
