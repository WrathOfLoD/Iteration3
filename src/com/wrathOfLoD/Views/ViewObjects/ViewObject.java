package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by echristiansen on 4/9/2016.
 */
public abstract class ViewObject extends JPanel {

	protected static final double TILE_THICKNESS = 5.0;

    private Image image;
    private Collection<ImageAnimation> animations;
    private String imageFilePath;
    private int offsetX = 0;
    private int offsetY = 0;

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

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
}
