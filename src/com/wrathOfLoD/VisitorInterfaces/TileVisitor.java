package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Map.Terrain.Terrain;
import com.wrathOfLoD.Models.Map.Tile;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface TileVisitor {

    public void visitTile(Tile tile);
    public void visitTerrain(Terrain terrain);

}
