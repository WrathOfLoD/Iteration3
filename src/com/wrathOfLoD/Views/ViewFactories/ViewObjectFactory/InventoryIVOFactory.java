package com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory;

import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class InventoryIVOFactory {

    public static ItemViewObject generateInventoryIVO(TakeableItem item) {
        ItemViewObject ivo = new ItemViewObject(item);
        Image image = ImageFactory.generateImage(Config.instance().getInventoryIVOPath()+item.getName()+Config.instance().getImageExtension());
        ivo.setImage(image);
        return ivo;
    }
}
