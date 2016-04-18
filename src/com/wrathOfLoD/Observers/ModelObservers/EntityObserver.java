package com.wrathOfLoD.Observers.ModelObservers;

import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import javafx.geometry.Pos;

/**
 * Created by luluding on 4/16/16.
 */
public interface EntityObserver {
    public void notifyMove(Position src, Position dest, Direction dir, int ticks);
    public void notifyDirectionChange(Direction dir);
}
