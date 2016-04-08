package com.wrathOfLoD.Views.ViewObjectFactory;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Views.ImageFactory.ItemImageFactory;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/8/2016.
 */
public class ItemViewObjectFactory {

    /*This class and the entire concept of ViewObjectFactory may be unnecessary */

    public static ItemViewObject createItemViewObject(Item item) {
        Image image = ItemImageFactory.generateImage(item.getName());
        ItemViewObject ivo = new ItemViewObject(item); //add a constructor that takes in an image?
        ivo.setItemImage(image);
        return ivo;
    }

}
