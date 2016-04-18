package com.wrathOfLoD.Views.ItemDisplayView.Slot;

import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/17/2016.
 */
public class ItemSlot extends Slot {

    public ItemViewObject getItemViewObject() {
        return (ItemViewObject)getStaticViewObject();
    }

    public ItemSlot(ItemViewObject itemViewObject) { //// TODO: 4/17/2016 which is better? cast needed?
        setStaticViewObject(itemViewObject);
    }


    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g, x, y, width, height);
        int slotPadding = 15;
        g.drawRect(x-slotPadding,y-slotPadding,width+(2*slotPadding),height+(2*slotPadding));

    }


}
