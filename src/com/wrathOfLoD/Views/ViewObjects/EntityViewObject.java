package com.wrathOfLoD.Views.ViewObjects;

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
        super(30); //zLevel
        setImage(ImageFactory.generateImage(Config.instance().getEntityVOPath()+entity.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + entity.getName() + "!!");
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {


       //TODO; draw self?
    }


}
