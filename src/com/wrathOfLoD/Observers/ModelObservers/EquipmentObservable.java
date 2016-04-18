package com.wrathOfLoD.Observers.ModelObservers;

import com.wrathOfLoD.Models.Items.TakeableItem;

/**
 * Created by echristiansen on 4/18/2016.
 */
public interface EquipmentObservable {
    void registerEquipmentObserver(EquipmentObserver eo);
    void removeEquipmentObserver(EquipmentObserver eo);
    void alertEquipmentChange(TakeableItem item);
}
