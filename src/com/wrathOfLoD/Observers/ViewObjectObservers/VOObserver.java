package com.wrathOfLoD.Observers.ViewObjectObservers;

import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ViewObjects.ModelViewObject;

/**
 * Created by luluding on 4/18/16.
 */
public interface VOObserver {
    public void notifyDestroy(ModelViewObject vo, Position position);
    public void notifyOnMove(ModelViewObject mvo, Position src, Position dest, Direction dir, int ticks);
}
