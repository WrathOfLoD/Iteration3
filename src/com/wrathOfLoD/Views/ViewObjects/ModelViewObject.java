package com.wrathOfLoD.Views.ViewObjects;

/**
 * Created by luluding on 4/15/16.
 */
public abstract class ModelViewObject extends ViewObject{
    private int zOrder; //smaller zOrder gets drawn at the bottom

    public ModelViewObject(int zOrder){
        this.zOrder = zOrder;
    }

    public int getzOrder(){
        return this.zOrder;
    }

    protected void setzOrder(int zOrder){
        this.zOrder = zOrder;
    }

}
