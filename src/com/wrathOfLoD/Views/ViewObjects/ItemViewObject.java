package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ItemViewObject extends ModelViewObject {

    private Item item;
    private boolean isDisplayed;
    private boolean isSelected;

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public boolean isDisplayed() {
        return isDisplayed;
    }
    public void setIsDisplayed(boolean displayed) {
        isDisplayed = displayed;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public ItemViewObject(){
        super(Config.getTakeableItemZLevel()); //zLevel
    }

    public ItemViewObject(Item item) {
        super(Config.getTakeableItemZLevel()); //zLevel
        setItem(item);
        //initializeImage(item);
        //setIsDisplayed(false);
    }

    public void initializeImage(Item item) {
        //setImage(ImageFactory.generateImage(Config.instance().getIVOPath()+item.getName()+Config.instance().getImageExtension()));
        setImage(ImageFactory.generateImage(Config.instance().getInventoryIVOPath()+item.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + item.getName() + "!!");
    }


    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g);
        g.drawImage(this.getImage(), x, y, width, height, this);
    }

}
