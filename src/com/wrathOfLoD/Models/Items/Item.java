package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    /***** getter & setter for Item *******/

    public String getName(){return this.name;}

    /********* END Getters and Setters *********/

    public abstract void encounter(Entity entity);
}
