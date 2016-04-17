package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class MapItemViewObject extends ItemViewObject {

    public MapItemViewObject(Item item, ImageAnimation imageAnimation) {
        super(item);
        setImage(imageAnimation.getFrame());
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x, y, width, height, this);
    }
}
