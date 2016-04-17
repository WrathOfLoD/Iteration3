package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TerrainVisitor;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

import java.awt.image.TileObserver;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Terrain {
    private String name;

    public Terrain() {}

    public void accept(TileVisitor tv){
        tv.visitTerrain(this);
    }

    public void accept(TerrainVisitor tv){
        tv.visitTerrain(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
