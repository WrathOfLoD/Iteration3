package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Map.Terrain.*;

/**
 * Created by zach on 4/17/16.
 */
public interface TerrainVisitor {

    void visitTerrain(Terrain t);

    void visitSkyTerrain(Sky sky);

    void visitGroundTerrain(Ground ground);

    void visitWaterTerrain(Water water);

    void visitNullTerrain(NullTerrain terrain);
}
