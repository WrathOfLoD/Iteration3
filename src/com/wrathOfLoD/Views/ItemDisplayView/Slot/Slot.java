package com.wrathOfLoD.Views.ItemDisplayView.Slot;

import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;
import com.wrathOfLoD.Views.ViewObjects.StaticViewObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 4/11/2016.
 */
public abstract class Slot extends StaticViewObject {

    private StaticViewObject staticViewObject;
    private boolean isSelected;

    public StaticViewObject getStaticViewObject() {
        return staticViewObject;
    }
    public void setStaticViewObject(StaticViewObject staticViewObject) {
        this.staticViewObject = staticViewObject;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void select(){
        setSelected(true);
    }

    public void addToSlot(StaticViewObject staticViewObject) {
        setStaticViewObject(staticViewObject);

    }

    public void removeFromSlot() {
        setStaticViewObject(null);
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.WHITE);
        if(getStaticViewObject()!=null) {
            getStaticViewObject().paintComponent(g,x,y,width,height);
            if (isSelected()) {
                g.setColor(Color.GREEN);
            }
        }
    }

}
