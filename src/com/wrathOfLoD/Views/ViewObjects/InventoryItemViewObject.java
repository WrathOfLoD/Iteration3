package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class InventoryItemViewObject extends ItemViewObject {

    public InventoryItemViewObject(TakeableItem item) {
        super(item);
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g,x,y,width,height);

//        if (this.getIsSelected()) {
//            Border b = BorderFactory.createLineBorder(Color.CYAN, 1);
//            b.paintBorder(this, g, x, y, width, height);
//        }
    }


}
