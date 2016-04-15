package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Observers.Observer;
import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.View;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ItemDisplayView extends StaticView implements Observer {

    private JPanel titlePanel;

    private ArrayList<ItemViewObject> ivoList = new ArrayList<ItemViewObject>(20); // TODO: 4/12/2016 remove this from here and put in inventory? add slots to inventory? 

    public JPanel getTitlePanel() {
        return titlePanel;
    }
    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public ArrayList<ItemViewObject> getIvoList() {
        return ivoList;
    }
    public void setIvoList(ArrayList<ItemViewObject> ivoList) {
        this.ivoList = ivoList;
    }

    public void addItemViewObject(ItemViewObject ivo) {
        ivoList.add(ivo);
    }
    public ItemViewObject getItemViewObject(int index) {
        return this.ivoList.get(index);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
