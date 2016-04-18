package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.StatsView.StatsViewObject;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ItemViewObject extends GraphicViewObject {

    public ItemViewObject() {
    }

    public ItemViewObject(Item item) { //todo change this constructor to take in Object object in accordance with PTC?
        setObject(item);
        setImageFilePath(Config.instance().getInventoryIVOPath()+item.getName()+Config.instance().getImageExtension());
        initializeImage(item);
    }

    public void initializeImage(Item item) {
        setImage(ImageFactory.generateImage(getImageFilePath())); //edit: testing. shouldn't be using this path
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g);
        g.drawImage(this.getImage(),x,y,width,height,this);
    }

}
