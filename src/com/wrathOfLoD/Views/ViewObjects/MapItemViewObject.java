package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Observers.ModelObservers.DestroyableModelObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.DestroyableVOObserver;
import com.wrathOfLoD.Observers.ViewObjectObservers.VOObservable;
import com.wrathOfLoD.Observers.ViewObjectObservers.VOObserver;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class MapItemViewObject extends ModelViewObject implements DestroyableModelObserver, VOObservable {
    private ArrayList<VOObserver> voObservers;

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public MapItemViewObject(Item item) {
        super(Config.getTakeableItemZLevel()); //zLevel
        setItem(item);
        initializeImage(getItem());
        voObservers = new ArrayList<>();
    }

    public MapItemViewObject(Item item, ImageAnimation imageAnimation) {
        super(Config.getTakeableItemZLevel());
        setItem(item);
        setImage(imageAnimation.getFrame());
        voObservers = new ArrayList<>();
    }

    public void initializeImage(Item item) {
        //setImage(ImageFactory.generateImage(Config.instance().getIVOPath()+item.getName()+Config.instance().getImageExtension()));
        setImage(ImageFactory.generateImage(Config.instance().getInventoryIVOPath() + item.getName() + Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + item.getName() + "!!");
    }

    @Override
    public void paintComponent(Graphics g, int x, int y, int width, int height, boolean visible) {
        Image renderedImage = this.getImage();
        if(!visible){
            renderedImage = getGrayscaleImage(renderedImage);
        }
        g.drawImage(renderedImage, x, y - 20, width, height, this);
    }


    //@Override
    public void notifyDestroy(Position position) {
        for(VOObserver voo : voObservers)
            voo.notifyDestroy(this, position);
    }

    @Override
    public void registerObserver(VOObserver voo) {
        voObservers.add(voo);
    }

    @Override
    public void deregisterObserver(VOObserver voo) {
        voObservers.remove(voo);
    }
}
