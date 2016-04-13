package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Models.Map.Terrain.Ground;
import com.wrathOfLoD.Models.Map.Terrain.Sky;
import com.wrathOfLoD.Models.Map.Terrain.Terrain;
import com.wrathOfLoD.Models.Map.Terrain.Water;
import com.wrathOfLoD.Models.Map.Tile;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface TileVisitor {

    void visitTile(Tile tile);
    void visitTerrain(Terrain terrain);
    void visitAreaEffect(AreaEffect areaEffect);

    void visitSkyTerrain(Sky sky);

    void visitGroundTerrain(Ground ground);

    void visitWaterTerrain(Water water);
}
