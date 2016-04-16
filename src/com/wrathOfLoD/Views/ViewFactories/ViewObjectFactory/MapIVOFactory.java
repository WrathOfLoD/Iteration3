package com.wrathOfLoD.Views.ViewFactories.ViewObjectFactory;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.ViewObjects.MapItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class MapIVOFactory {

    public static MapItemViewObject generateMapIVO(Item item) {
        MapItemViewObject ivo = new MapItemViewObject(item);
        Image image = ImageFactory.generateImage(Config.instance().getMapIVOPath()+item.getName()+Config.instance().getImageExtension());
        ivo.setImage(image);
        return ivo;
    }

}
