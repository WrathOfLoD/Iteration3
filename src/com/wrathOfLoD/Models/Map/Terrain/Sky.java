package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class Sky extends Terrain {
    public Sky() {
        super();
    }

    public void accept(TileVisitor tv){
        tv.visitSkyTerrain(this);
    }
}
