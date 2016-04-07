package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Item {
    private Position position;
    private String name;

    public Item(Position position, String name){
        this.position = position;
        this.name = name;
    }

    public void updatePosition(Position newPosition){
        this.position = newPosition;
    }

    public Position getPositon(){
        return this.position;
    }

    //Needs encounter(Entity entity)
}
