package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public class TilePillar {
    private Tile[] tiles;
    private int horizon;
    private boolean discovered;
    private boolean visible;

    public TilePillar() {
        // 10 is height of a TilePillar, 0-9
        this.tiles = new Tile[10];
    }

    public Tile getTile(Position p) {
        return this.tiles[p.getH()];
    }

    public void addEntity(Entity entity, Position position) {
        this.tiles[position.getH()].add(entity);
    }
}
