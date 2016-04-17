package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Terrain.*;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.Trap;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface TileVisitor {

    void visitTile(Tile tile);
    void visitTerrain(Terrain terrain);
    //void visitAreaEffect(AreaEffect areaEffect);
    //moved to its own interface


    void visitTrap(Trap trap);

    void visitSkyTerrain(Sky sky);

    void visitGroundTerrain(Ground ground);

    void visitWaterTerrain(Water water);

    void visitNullTerrain(NullTerrain terrain);
}
