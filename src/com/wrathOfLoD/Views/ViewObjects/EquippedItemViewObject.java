package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class EquippedItemViewObject extends ItemViewObject {

    public EquippedItemViewObject(EquippableItem item) {
        super(item);
    }

    public EquippedItemViewObject() {

    }

//    public void initializeImage() {
//        setImage(ImageFactory.generateImage(Config.instance().getEquippedIVOPath()+getItem().getName()+Config.instance().getImageExtension()));
//        System.out.println("The proper initializeImage is getting called EQUIPMENTItemViewObject!" + getItem().getName());
//    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g,x,y,width,height);

//        if (this.getIsSelected()) {
//            Border b = BorderFactory.createLineBorder(Color.CYAN, 1);
//            b.paintBorder(this, g, x, y, width, height);
//        }
    }


}
