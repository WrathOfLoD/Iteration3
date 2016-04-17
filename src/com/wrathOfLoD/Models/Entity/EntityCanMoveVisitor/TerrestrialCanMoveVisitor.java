package com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor;

import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.NullTerrain;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Terrain.Water;

/**
 * Created by luluding on 4/16/16.
 */
public class TerrestrialCanMoveVisitor extends CanMoveVisitor{
    @Override
    public void visitSkyTerrain(Sky sky) {
        setCanMove(false);
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
