package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class InventoryItemViewObject extends ItemViewObject {

    public InventoryItemViewObject(TakeableItem item) {
        super(item);
    }

    public void initializeImage(TakeableItem item) { //edit: should it be item or takeable item?
        setImage(ImageFactory.generateImage(Config.instance().getInventoryIVOPath()+item.getName()+Config.instance().getImageExtension()));
        System.out.println("The proper initializeImage is getting called InventoryItemViewObject!");
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g,x,y,width,height);
    }


}
