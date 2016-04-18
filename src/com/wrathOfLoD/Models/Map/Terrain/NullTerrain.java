package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TerrainVisitor;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by luluding on 4/16/16.
 */
public class NullTerrain extends Terrain{
    public NullTerrain() {
        super();
        this.setName("SkyTile");
    }

    public void accept(TileVisitor tv){
        tv.visitNullTerrain(this);
    }

    public void accept(TerrainVisitor tv){
        tv.visitNullTerrain(this);
    }
}
