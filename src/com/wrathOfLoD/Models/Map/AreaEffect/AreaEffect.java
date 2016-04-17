package com.wrathOfLoD.Models.Map.AreaEffect;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.SaveLoad.XMLSaver;
import com.wrathOfLoD.VisitorInterfaces.AreaEffectVisitor;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by zach on 4/7/16.
 */
public abstract class AreaEffect {
    private String name;

    public AreaEffect(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void interact(Entity entity);

    public void accept(AreaEffectVisitor aev){
        aev.visitAreaEffect(this);
    }
}
