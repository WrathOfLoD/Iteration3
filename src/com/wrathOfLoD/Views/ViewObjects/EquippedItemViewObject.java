package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquippedItemViewObject extends ItemViewObject {

    public EquippedItemViewObject(EquippableItem item) {
        super(item);
    }

    public EquippedItemViewObject() {

    }

    public void initializeImage() {
        setImage(ImageFactory.generateImage(Config.instance().getEquippedIVOPath()+getItem().getName()+Config.instance().getImageExtension()));
        System.out.println("The proper initializeImage is getting called InventoryItemViewObject!");
    }

}
