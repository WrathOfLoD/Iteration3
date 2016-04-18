package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

import java.awt.*;
import java.util.Objects;

/**
 * Created by echristiansen on 4/17/2016.
 */
public class GraphicViewObject extends StaticViewObject  {

    private Image image;
    private String imageFilePath;

    public String getImageFilePath() {
        return imageFilePath;
    }
    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public void initializeImage() {
        setImage(ImageFactory.generateImage(getImageFilePath())); //edit: testing. shouldn't be using this path
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        super.paintComponent(g);
        g.drawImage(this.getImage(),x,y,width,height,this);

    }
}
