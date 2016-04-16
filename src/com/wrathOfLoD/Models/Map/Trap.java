package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by luluding on 4/16/16.
 */
public class Trap {
    private int damage;
    private boolean visible;

    public Trap(int damage){
        this.damage = damage;
        this.visible = false;
    }

    public void interact(Entity entity){
        entity.takeDamage(damage);
    }

    public boolean remove(){
        if(!visible)
            return false;
        else{
            //TODO: remove self from tile
            return true;
        }
    }
}
