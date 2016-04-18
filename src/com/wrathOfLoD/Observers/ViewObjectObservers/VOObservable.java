package com.wrathOfLoD.Observers.ViewObjectObservers;

/**
 * Created by luluding on 4/18/16.
 */
public interface VOObservable {

    public void registerObserver(VOObserver voo);
    public void deregisterObserver(VOObserver voo);
}
