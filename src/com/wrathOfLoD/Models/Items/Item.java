package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Item {
    private String name;
    private int value = 10;

    public Item(String name){
        this.name = name;
    }

    /***** getter & setter for Item *******/

    public String getName(){return this.name;}

    public int getValue() {
        return value;
    }

    /********* END Getters and Setters *********/

    public abstract void encounter(Entity entity);

    public void accept(ItemVisitor iv){
        iv.visitItem(this);
    }
}
