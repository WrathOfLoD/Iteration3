package com.wrathOfLoD.Views.ItemDisplayView;

import com.wrathOfLoD.Views.StaticView;
import com.wrathOfLoD.Views.View;
import com.wrathOfLoD.Views.ViewObjects.ItemViewObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by erik on 4/7/2016.
 */
public abstract class ItemDisplayView extends StaticView {

    private ArrayList<ItemViewObject> ivoList;

    public ArrayList<ItemViewObject> getIvoList() {
        return ivoList;
    }
    public void setIvoList(ArrayList<ItemViewObject> ivoList) {
        this.ivoList = ivoList;
    }


}
