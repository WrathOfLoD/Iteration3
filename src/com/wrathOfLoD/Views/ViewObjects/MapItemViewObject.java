package com.wrathOfLoD.Views.ViewObjects;

import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Utility.Config;
import com.wrathOfLoD.Views.ImageFactory.ImageFactory;

/**
 * Created by echristiansen on 4/9/2016.
 */
public class MapItemViewObject extends ModelViewObject {

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

    public void initializeImage(Item item) {
        setImage(ImageFactory.generateImage(Config.instance().getMapIVOPath()+item.getName()+Config.instance().getImageExtension()));
        System.out.println("The proper initializeImage is getting called MapItemViewObject!");
    }

}
