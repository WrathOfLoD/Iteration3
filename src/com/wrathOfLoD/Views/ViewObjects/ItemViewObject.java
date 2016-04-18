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
public class ItemViewObject extends StaticViewObject {

    private Image image;
    private boolean isDisplayed;
    private boolean isSelected; // TODO: 4/17/2016 moved this to slots? 

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public boolean isDisplayed() {
        return isDisplayed;
    }
    public void setIsDisplayed(boolean displayed) {
        isDisplayed = displayed;
    }
    public boolean getIsSelected() {
        return isSelected;
    }
    public void setIsSelected(boolean selected) {
        isSelected = selected;
    }

    public ItemViewObject() {

    }

    public ItemViewObject(Item item) { //todo change this constructor to take in Object object in accordance with PTC?
        //setItem(item);
        setObject(item);
        setIsSelected(false);
        initializeImage(item);
    }

    public void initializeImage(Item item) {
        //setImage(ImageFactory.generateImage(Config.instance().getIVOPath()+item.getName()+Config.instance().getImageExtension()));
        setImage(ImageFactory.generateImage(Config.instance().getInventoryIVOPath()+item.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + item.getName() + "!!");
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        //super.paintComponent(g, x, y, width, height);
        super.paintComponent(g);
        g.drawImage(this.getImage(),x,y,width,height,this);
        //System.out.println("CALLING PAINT COMPONENT FROM ITEMVIEW OBJEDCT");
        //System.out.println();
        if (this.getIsSelected()) { // TODO: 4/17/2016 delete this because it's been moved to slots? 
            Border b = BorderFactory.createLineBorder(Color.CYAN, 1);
            b.paintBorder(this, g, x, y, width, height);
        }
    }


}
