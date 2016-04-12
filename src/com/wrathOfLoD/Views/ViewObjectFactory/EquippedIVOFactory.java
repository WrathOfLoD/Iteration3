package com.wrathOfLoD.Views.ViewObjectFactory;

import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.ViewObjects.EquippedItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.InventoryItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquippedIVOFactory {

    public static EquippedItemViewObject generateEquippedIVO(EquippableItem item) {
        if(item!=null) {
            EquippedItemViewObject ivo = new EquippedItemViewObject(item);
            Image image = ImageFactory.generateImage(Config.instance().getEquippedIVOPath()+item.getName()+Config.instance().getImageExtension());
            System.out.println("Accessing filepath: " + Config.instance().getEquippedIVOPath()+item.getName()+Config.instance().getImageExtension());
            ivo.setImage(image);
            return ivo;

        } else {
            return new EquippedItemViewObject(); // TODO: 4/12/2016 is doing this ok? relying on an empty constructor to create null EquippedIVO into Slots
        }

    }

}
