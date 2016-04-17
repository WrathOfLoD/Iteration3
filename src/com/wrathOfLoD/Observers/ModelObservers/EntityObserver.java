package com.wrathOfLoD.Observers.ModelObservers;

import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/16/16.
 */
public interface EntityObserver {
    public void notifyMove(Position src, Position dest, Direction dir, int ticks);
}
