package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Item {
    private Position position;
    private String name;

    public Item(String name){
        this.name = name;
    }

    //note we want to get rid of Position from Item
    public Item(Position position, String name){
        this.position = position;
        this.name = name;
    }

    /***** getter & setter for Item *******/

    public Position getPositon(){
        return this.position;
    }

    public String getName(){return this.name;}

    /********* END Getters and Setters *********/

    public abstract void encounter(Entity entity);

    public void updatePosition(Position newPosition){
        this.position = newPosition;
    }
}
