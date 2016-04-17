package com.wrathOfLoD.Observers.ViewObjectObservers;

import com.wrathOfLoD.Views.ViewObjects.ModelViewObject;

/**
 * Created by luluding on 4/17/16.
 */
public interface DestroyableVOObserver {

    public void notifyDestroy(ModelViewObject vo);
}
