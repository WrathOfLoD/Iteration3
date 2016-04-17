package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBox;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by luluding on 4/17/16.
 */
public class HitBoxViewObject extends ModelViewObject implements DestroyableModelObserver, DestroyableVOObservable{
    private HitBox hitBox;
    private ArrayList<DestroyableVOObserver> destroyableVOObservers;

    public HitBoxViewObject(HitBox hitBox, ImageAnimation imageAnimation){
        super(Config.getHitBoxZLevel());
        this.hitBox = hitBox;
        setImage(imageAnimation.getFrame());
        destroyableVOObservers = new ArrayList<>();
    }


    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x, y, this.getImage().getWidth(null), this.getImage().getHeight(null), this);
    }

    @Override
    public void notifyDestroy() {
        for(DestroyableVOObserver dvoo: destroyableVOObservers){
            dvoo.notifyDestroy(this);
        }
    }

    @Override
    public void registerObserver(DestroyableVOObserver dvoo) {
        destroyableVOObservers.add(dvoo);
    }

    @Override
    public void deregisterObserver(DestroyableVOObserver dvoo) {
        destroyableVOObservers.add(dvoo);
    }
}
