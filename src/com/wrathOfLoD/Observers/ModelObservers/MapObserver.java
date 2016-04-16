package com.wrathOfLoD.Observers.ModelObservers;

import com.wrathOfLoD.Models.Map.MapArea;

/**
 * Created by luluding on 4/16/16.
 */
public interface MapObserver {
    public void notifyMapAreaChange(MapArea ma);
}
