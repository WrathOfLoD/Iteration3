package com.wrathOfLoD.Observers;

/**
 * Created by echristiansen on 4/12/2016.
 */
public interface Observable {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

}
