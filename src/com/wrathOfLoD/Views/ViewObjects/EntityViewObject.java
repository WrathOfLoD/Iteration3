package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;

/**
 * Created by luluding on 4/15/16.
 */
public class EntityViewObject extends ModelViewObject{
    private Entity entity;

    public EntityViewObject(Entity entity, ImageAnimation imageAnimation) {
        super(Config.getEntityZLevel());
        setImage(imageAnimation.getFrame());
        //setImage(ImageFactory.generateImage(Config.instance().getEntityVOPath()+entity.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + entity.getName() + "!!");
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x + getOffsetX(), y + getOffsetY(), width, height, this);
    }
}
