package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TerrainVisitor;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by zach on 4/7/16.
 */
public class Ground extends Terrain {
    public Ground() {
        super();
        this.setName("SpaceRockGrassTile");
    }


    public void accept(TileVisitor tv){
        tv.visitGroundTerrain(this);
    }
    public void accept(TerrainVisitor tv){
        tv.visitGroundTerrain(this);
    }
}
