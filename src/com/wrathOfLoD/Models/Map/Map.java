package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class Map {
    private static Map instance = null;

    private Collection<MapArea> mapAreas;
    private MapArea activeMapArea;

    protected Map() {
        this.mapAreas = new HashSet<MapArea>();
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

	///TODO do I need to add stuff for all of the sub-components?
	public void init(Collection<MapArea> mapAreas, MapArea activeMapArea){
		this.mapAreas.clear();
		this.mapAreas.addAll(mapAreas);
		this.setActiveMapArea(activeMapArea);
	}

    public Tile getTile(Position p) {
        return this.activeMapArea.getTile(p.get2DProjection());
    }

    public List<Tile> getTiles(List<Position> pList) {
        return this.activeMapArea.getTiles(pList);
    }

    public void setActiveMapArea(MapArea mArea){
		if(mapAreas.contains(mArea)){
			this.activeMapArea = mArea;
		}
		else{
			throw new IllegalArgumentException("Selected MapArea is not contained in the collection of MapAreas.");
		}
	}

    public void addEntity(Entity entity, Position pos){
		this.activeMapArea.addEntity(entity, pos);
	}

}


