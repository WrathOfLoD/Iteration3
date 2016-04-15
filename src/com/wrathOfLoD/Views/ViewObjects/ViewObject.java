package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by echristiansen on 4/9/2016.
 */
public abstract class ViewObject extends JPanel {

    private Image image;
    private Collection<ImageAnimation> animations;
    private String imageFilePath;

    public String getFilePath() {
        return imageFilePath;
    }
    public void setFilePath(String filePath) {
        this.imageFilePath = filePath;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image itemImage) {
        this.image = itemImage;
    }

}
