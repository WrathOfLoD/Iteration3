package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Observers.ModelObservers.EntityObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.MovableVOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.MovableVOObserver;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by luluding on 4/15/16.
 */
public class EntityViewObject extends ModelViewObject implements EntityObserver, MovableVOObservable{
    private Entity entity;
    private ArrayList<MovableVOObserver> movableVOObservers;

    public EntityViewObject(Entity entity, ImageAnimation imageAnimation) {
        super(Config.getEntityZLevel());
        setImage(imageAnimation.getFrame());
        movableVOObservers = new ArrayList<>();
        //setImage(ImageFactory.generateImage(Config.instance().getEntityVOPath()+entity.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + entity.getName() + "!!");
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x, y, this.getImage().getWidth(null), this.getImage().getHeight(null), this);

    }


    @Override
    public void notifyMove(Position src, Position dest, Direction dir, int ticks) {
        for(MovableVOObserver mvoo : movableVOObservers){
            mvoo.notifyOnMove(this, src, dest, dir, ticks);
        }
    }

    @Override
    public void registerObserver(MovableVOObserver mvoo) {
        movableVOObservers.add(mvoo);
    }

    @Override
    public void deregisterObserver(MovableVOObserver mvoo) {
        movableVOObservers.remove(mvoo);
    }
}
