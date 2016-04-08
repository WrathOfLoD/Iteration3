package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.ImageFactory.ItemImageFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by erik on 4/7/2016.
 */
public class ItemViewObject extends JPanel{

    private Item item;
    private Image itemImage;
    private boolean isDisplayed;
    private boolean isSelected;

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public Image getItemImage() {
        return itemImage;
    }
    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
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

    public ItemViewObject() { }

    public ItemViewObject(Item item) {
        this.setItem(item);
        this.setItemImage(ItemImageFactory.generateImage(item));
        this.setIsDisplayed(false);
    }

    public ItemViewObject(Item item, int width, int height) {
        this.setItem(item);
        this.setItemImage(ItemImageFactory.generateScaledImage(item, width, height));
        this.setIsDisplayed(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g);
        g.drawImage(this.getItemImage(), x, y, width, height, this);
    }

}
