package com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor;

import com.wrathOfLoD.Models.Map.Terrain.NullTerrain;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Terrain.Water;

/**
 * Created by Ian on 4/17/2016.
 */
public class FlyingCanMoveVisitor extends CanMoveVisitor{
    @Override
    public void visitSkyTerrain(Sky sky) {
        setCanMove(true);
    }

    @Override
    public void visitWaterTerrain(Water water) {
        setCanMove(false);
    }

    @Override
    public void visitNullTerrain(NullTerrain terrain) {
        setCanMove(false);
    }
}
