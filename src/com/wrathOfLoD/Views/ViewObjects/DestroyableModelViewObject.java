package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;
import com.wrathOfLoD.Views.SpriteMap.ImageAnimation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class MapItemViewObject extends ModelViewObject {
    private ArrayList<DestroyableVOObserver> destroyableVOObservers;

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
    }

    public MapItemViewObject(Item item, ImageAnimation imageAnimation) {
        super(Config.getTakeableItemZLevel());
        setItem(item);
        setImage(imageAnimation.getFrame());
        destroyableVOObservers = new ArrayList<>();
    }

    public void initializeImage(Item item) {
        //setImage(ImageFactory.generateImage(Config.instance().getIVOPath()+item.getName()+Config.instance().getImageExtension()));
        setImage(ImageFactory.generateImage(Config.instance().getInventoryIVOPath() + item.getName() + Config.instance().getImageExtension())); //edit: testing. shouldn't be using this path
        System.out.println("initalizeImage is getting called for : " + item.getName() + "!!");
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
