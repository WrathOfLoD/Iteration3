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
import java.util.Map;

/**
 * Created by luluding on 4/15/16.
 */
public class EntityViewObject extends ModelViewObject implements EntityObserver, MovableVOObservable{
    private Entity entity;
    private Direction facingDirection;
    private ArrayList<MovableVOObserver> movableVOObservers;
    private Map<Direction, ImageAnimation> imageAnimationMap;
    private HealthBarViewObject healthBarViewObject;

    public EntityViewObject(Entity entity, ImageAnimation imageAnimation, HealthBarViewObject healthBarViewObject) {
        super(Config.getEntityZLevel());
//        this.imageAnimationMap = imageMap;
        this.facingDirection = Direction.SOUTH;
        setImage(imageAnimation.getFrame());
//        setImage(this.imageAnimationMap.get(this.facingDirection).getFrame());
        this.entity = entity;
        this.healthBarViewObject = healthBarViewObject;
        movableVOObservers = new ArrayList<>();

        //setImage(ImageFactory.generateImage(Config.instance().getEntityVOPath()+entity.getName()+Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + entity.getName() + "!!");
    }

    public void paintComponent(Graphics g, int x, int y, int width, int height) {
//        Image image = this.imageAnimationMap.get(this.facingDirection).getFrame();

        g.drawImage(this.getImage(), x, y, this.getImage().getWidth(null), this.getImage().getHeight(null), this);
        //healthBarViewObject.paintComponent(g, x, y-20, width, height);
        healthBarViewObject.paintHealthBar(g, x+15, y+10, width, height, entity.getStats().getMaxHealth(), entity.getStats().getCurrentHealth());
    }


    @Override
    public void notifyMove(Position src, Position dest, Direction dir, int ticks) {
        for(MovableVOObserver mvoo : movableVOObservers){
            mvoo.notifyOnMove(this, src, dest, dir, ticks);
        }
    }

    public void notifyDirectionChange(Direction dir) {
        this.facingDirection = dir;
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
