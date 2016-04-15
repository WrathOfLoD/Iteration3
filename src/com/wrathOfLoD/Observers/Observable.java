package com.wrathOfLoD.Observers;

/**
 * Created by echristiansen on 4/12/2016.
 */
public interface Observable {

    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
