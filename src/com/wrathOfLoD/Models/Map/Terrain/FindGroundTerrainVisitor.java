package com.wrathOfLoD.Models.Map.Terrain;

import com.wrathOfLoD.VisitorInterfaces.TerrainVisitor;

/**
 * Created by zach on 4/17/16.
 */
public class FindGroundTerrainVisitor implements TerrainVisitor {
    private boolean hitGroundLevel;

    @Override
    public void visitTerrain(Terrain t) {
        hitGroundLevel = false;
    }

    @Override
    public void visitSkyTerrain(Sky sky) {
        hitGroundLevel = false;
    }

    @Override
    public void visitGroundTerrain(Ground ground) {
        hitGroundLevel = true;
    }

    @Override
    public void visitWaterTerrain(Water water) {
        hitGroundLevel = true;
    }

    @Override
    public void visitNullTerrain(NullTerrain terrain) {
        hitGroundLevel = false;
    }

    public boolean isHitGroundLevel() { return hitGroundLevel; }
}
