package com.wrathOfLoD.Views.ItemDisplayView.Slot;

import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

/**
 * Created by echristiansen on 4/11/2016.
 */
public class InventorySlot extends Slot {


    public ItemViewObject getItemViewObject() {
        return (ItemViewObject)getStaticViewObject();
    }

    public InventorySlot(ItemViewObject itemViewObject) { //// TODO: 4/17/2016 which is better? cast needed?
        setStaticViewObject(itemViewObject);
    }


}
