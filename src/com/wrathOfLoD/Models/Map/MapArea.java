package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class MapArea {
    private HashMap<Position, TilePillar> tilePillarMap;

    public MapArea() {
        this.tilePillarMap = new HashMap<Position, TilePillar>();
    }

    public Tile getTile(Position p) {
        Tile t = this.tilePillarMap.get(p).getTile(p);

        return t;
    }

    public List<Tile> getTiles(List<Position> pList) {
        List<Tile> tiles = new ArrayList<>();

        pList.stream()
             .forEach(p -> tiles.add(this.getTile(p)));

        return tiles;
    }

    public void addEntity(Entity entity, Position position) {}
}
