package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

import java.awt.image.TileObserver;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Terrain {

    public Terrain() {}

    public void accept(TileVisitor tv){
        tv.visitTerrain(this);
    }
}
