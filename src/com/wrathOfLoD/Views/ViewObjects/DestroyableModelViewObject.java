package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class DestroyableModelViewObject extends ItemViewObject implements DestroyableModelObserver, DestroyableVOObservable{
    private ArrayList<DestroyableVOObserver> destroyableVOObservers;

    public DestroyableModelViewObject(Item item, ImageAnimation imageAnimation) {
        super(item);
        setImage(imageAnimation.getFrame());
        destroyableVOObservers = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height) {
        g.drawImage(this.getImage(), x, y - 20, width, height, this);
    }

    @Override
    public void registerObserver(DestroyableVOObserver dvoo) {
        destroyableVOObservers.add(dvoo);
    }

    @Override
    public void deregisterObserver(DestroyableVOObserver dvoo) {
        destroyableVOObservers.remove(dvoo);

    }

    @Override
    public void notifyDestroy() {
        for(DestroyableVOObserver dvoo : destroyableVOObservers)
            dvoo.notifyDestroy(this);
    }
}
