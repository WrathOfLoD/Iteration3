package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

import java.awt.geom.Area;

/**
 * Created by luluding on 4/16/16.
 */
public class Trap {
    private int damage;
    private boolean visible;

    public Trap(int damage){
        this.damage = damage;
        visible = false;
    }

    public void interact(Entity entity) {
        entity.takeDamage(damage);
    }

    public boolean isVisible(){
        return visible;
    }

    public void detected(){
        this.visible = true;
    }

    public void accept(TileVisitor tv){
        tv.visitTrap(this);
    }
}
