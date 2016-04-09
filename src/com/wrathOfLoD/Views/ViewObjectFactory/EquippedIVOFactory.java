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
        EquippedItemViewObject ivo = new EquippedItemViewObject(item);
        Image image = ImageFactory.generateImage(Config.instance().getEquippedIVOPath()+item.getName()+Config.instance().getImageExtension());
        ivo.setImage(image);
        return ivo;
    }

}
