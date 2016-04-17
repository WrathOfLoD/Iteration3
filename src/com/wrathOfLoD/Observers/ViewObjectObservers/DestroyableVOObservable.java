package com.wrathOfLoD.Observers.ViewObjectObservers;

/**
 * Created by luluding on 4/17/16.
 */
public interface DestroyableVOObservable {
    public void registerObserver(DestroyableVOObserver dvoo);
    public void deregisterObserver(DestroyableVOObserver dvoo);
}
