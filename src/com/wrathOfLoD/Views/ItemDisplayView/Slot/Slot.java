package com.wrathOfLoD.Views.ItemDisplayView.Slot;

import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/11/2016.
 */
public abstract class Slot {
    private ItemViewObject item;

    public ItemViewObject getItem() {
        return item;
    }
    public void setItem(ItemViewObject item) {
        this.item = item;
    }

    public Slot(ItemViewObject item) {
        addToSlot(item);
    }


    public void addToSlot(ItemViewObject item) {
        setItem(item);
    }

    public void removeFromSlot() {
        setItem(null);
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        if(getItem()!=null) {
            getItem().paintComponent(g,x,y,width,height);
        }
    }

}
