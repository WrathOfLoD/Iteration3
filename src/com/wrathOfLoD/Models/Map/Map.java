package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class Map {
    private static Map instance = null;

    private List<MapArea> mapAreas;
    private MapArea activeMapArea;

    protected Map() {
        this.mapAreas = new ArrayList<>();
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public Tile getTile(Position p) {
        return this.activeMapArea.getTile(p.get2DPosition());
    }

    public List<Tile> getTiles(List<Position> pList) {
        return this.activeMapArea.getTiles(pList);
    }

    public void setActiveMapArea(MapArea mArea) {
        this.activeMapArea = mArea;

        // Update the LocationTrackerManager's reference
        LocationTrackerManager.getInstance().updateActiveMapArea(this.activeMapArea);
    }

    public void addEntity(Entity entity, Position position) {
        this.activeMapArea.addEntity(entity, position);


    }

    // TODO: 4/8/16 MAKE A REMOVEENTITY

}


