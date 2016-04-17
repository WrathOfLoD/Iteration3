package com.wrathOfLoD.Views.ItemDisplayView.Slot;

import com.wrathOfLoD.Views.Selectable;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.StaticViewObject;

/**
 * Created by echristiansen on 4/11/2016.
 */
public class InventorySlot extends Slot {

//    public InventorySlot(ItemViewObject itemViewObject) {
//        setStaticViewObject(itemViewObject); //// TODO: 4/17/2016 does this work? is this PTC violation? Stronger precondition? Actually there is no constructor in Slot so no?
//    }

    public ItemViewObject getItemViewObject() {
        return (ItemViewObject)getStaticViewObject();
    }

//    public InventorySlot(StaticViewObject staticViewObject) { //// TODO: 4/17/2016 which is better? cast needed?
//        setStaticViewObject(staticViewObject);
//    }

    public InventorySlot(ItemViewObject itemViewObject) { //// TODO: 4/17/2016 which is better? cast needed?
        setStaticViewObject(itemViewObject);
    }




}
