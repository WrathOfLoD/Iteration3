package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;

/**
 * Created by luluding on 4/16/16.
 */
public class AreaEffectViewObject extends ModelViewObject{
    private AreaEffect areaEffect;

    public AreaEffectViewObject(AreaEffect ae, ImageAnimation imageAnimation){
        super(Config.getAreaEffectZLevel());
        this.areaEffect = ae;
        setImage(imageAnimation.getFrame());
    }


    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x, y, this.getImage().getWidth(null), this.getImage().getHeight(null), this);
    }
}
