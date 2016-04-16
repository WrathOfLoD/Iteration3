package com.wrathOfLoD.Views.ViewObjects;

import com.sun.tools.corba.se.idl.ConstGen;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

import java.awt.*;

/**
 * Created by luluding on 4/15/16.
 */
public class EntityViewObject extends ModelViewObject{
    private Entity entity;

    public EntityViewObject(Entity entity) {
        super(Config.getEntityZLevel());
        setImage(ImageFactory.generateImage(Config.instance().getEntityVOPath()+entity.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + entity.getName() + "!!");
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x + getOffsetX(), y + getOffsetY(), width, height, this);
    }
}
