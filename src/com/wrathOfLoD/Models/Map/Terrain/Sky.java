package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TerrainVisitor;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class Sky extends Terrain {
    public Sky() {
        super();
        this.setName("SkyTile");
    }


    public void accept(TileVisitor tv){
        tv.visitSkyTerrain(this);
    }
    public void accept(TerrainVisitor tv){
        tv.visitSkyTerrain(this);
    }
}
