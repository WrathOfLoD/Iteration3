package com.wrathOfLoD.Views.ViewObjects;


import javax.swing.*;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;

/**
 * Created by luluding on 4/15/16.
 */
public abstract class ModelViewObject extends ViewObject{
    private int zOrder; //smaller zOrder gets drawn at the bottom

    public ModelViewObject() {

    }

    public ModelViewObject(int zOrder){
        this.zOrder = zOrder;
    }

    public int getzOrder(){
        return this.zOrder;
    }

    protected void setzOrder(int zOrder){
        this.zOrder = zOrder;
    }

    public abstract void paintComponent(Graphics g, int x, int y, int width, int height, boolean visible);

    protected Image getGrayscaleImage(Image img){
        ImageFilter filter = new GrayFilter(true, 50);
        ImageProducer producer = new FilteredImageSource(img.getSource(), filter);
        Image renderedImage = Toolkit.getDefaultToolkit().createImage(producer);
        return renderedImage;
    }

}
