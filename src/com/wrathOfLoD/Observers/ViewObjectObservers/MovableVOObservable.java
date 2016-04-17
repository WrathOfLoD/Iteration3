package com.wrathOfLoD.Observers.ViewObjectObservers;

import com.wrathOfLoD.Observers.ModelObservers.EntityObserver;

/**
 * Created by luluding on 4/16/16.
 */
public interface MovableVOObservable {
    public void registerObserver(MovableVOObserver mvoo);
    public void deregisterObserver(MovableVOObserver mvoo);
}
