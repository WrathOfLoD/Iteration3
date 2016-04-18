package com.wrathOfLoD.Observers.ModelObservers;

import com.wrathOfLoD.Models.Items.TakeableItem;

/**
 * Created by echristiansen on 4/18/2016.
 */
public interface EquipmentObserver {
    void equipmentAlertResponse(TakeableItem item);
}
