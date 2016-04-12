package com.wrathOfLoD.Observers;

import com.wrathOfLoD.Models.Items.TakeableItem;

/**
 * Created by echristiansen on 4/12/2016.
 */
public interface InventoryObserver {

    public void alertItemAdded(TakeableItem item);
    public void alertItemDropped(TakeableItem item);

}
