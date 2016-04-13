package com.wrathOfLoD.Views.ItemDisplayView.Slot;

import com.wrathOfLoD.Views.ViewObjects.EquippedItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;

/**
 * Created by echristiansen on 4/11/2016.
 */
public class EquipmentSlot extends Slot{
    /* By PTC, if EquipmentSlot is  a subtype/subclass of Slot, I cannot have its add method take in a stronger parameter than Takeable Item
    * (or whatever I paramterize add with in the Slot class. This means the add needs
    * ......what's the point then?
    *
    * Does PTC apply to constructors? (Can only pass in type as weaker or weaker than that passed into superclass oonstructor? */

    public EquipmentSlot(ItemViewObject item) {
        super(item);
    }

    /*
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        if(getItem()!=null) {
            getItem().paintComponent(g,x,y,width,height);
        }
    }
*/

}
