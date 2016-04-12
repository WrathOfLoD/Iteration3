package com.wrathOfLoD.Observers;

import com.wrathOfLoD.Models.Items.TakeableItem;

/**
 * Created by echristiansen on 4/12/2016.
 */
public interface InventoryObserver {

    void alertItemAdded(TakeableItem item);
    void alertItemDropped(TakeableItem item);

}
