package com.wrathOfLoD.Observers.ModelObservers;

import com.wrathOfLoD.Observers.Observer;

/**
 * Created by luluding on 4/16/16.
 */
public interface EntityObservable {
    public void registerObserver(EntityObserver eo);
    public void deregisterObserver(EntityObserver eo);
}
