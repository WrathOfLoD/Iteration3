package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.AreaEffect.AreaEffect;
import com.wrathOfLoD.Observers.ModelObservers.MapObservable;
import com.wrathOfLoD.Observers.ModelObservers.MapObserver;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.MapVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class Map implements MapObservable{
    private static Map instance = null;

    private Collection<MapArea> mapAreas;
    private MapArea activeMapArea;
	private ArrayList<MapObserver> mapObservers;


    protected Map() {
        this.mapAreas = new HashSet<MapArea>();
		this.mapObservers = new ArrayList<>();
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

	public void setActiveMapArea(MapArea mArea){
		if(mapAreas.contains(mArea)){
			this.activeMapArea = mArea;
			LocationTrackerManager.getInstance().updateActiveMapArea(this.activeMapArea);
			for(MapObserver mo : mapObservers)
				mo.notifyMapAreaChange(mArea);
		}
		else{
			throw new IllegalArgumentException("Selected MapArea is not contained in the collection of MapAreas.");
		}
	}

	//TODO: testing purpose, can remove
	public void addMapArea(MapArea mapArea){
		this.mapAreas.add(mapArea);
	}

	public boolean hasTilePillarAt(Position pos){
		return this.activeMapArea.hasTilePillarAt(pos);
	}

	public TilePillar getTilePillar(Position pos){
		TilePillar pillar = this.activeMapArea.getTilePillar(pos);
		return pillar;
	}

	public boolean hasTileAt(Position pos){
		return this.activeMapArea.hasTileAt(pos);
	}

    public Tile getTile(Position pos) {
        Tile tile = this.activeMapArea.getTile(pos);
		return tile;
    }

    public List<Tile> getTiles(List<Position> pList) {
        return this.activeMapArea.getTiles(pList);
    }

	public MapArea[] getMapAreas(){
		return mapAreas.toArray(new MapArea[mapAreas.size()]);
	}

	public void accept(MapVisitor mapVisitor){
		mapVisitor.visitMap(this);
	}

	@Override
	public void registerObserver(MapObserver mo) {
		mapObservers.add(mo);
	}

	@Override
	public void deregisterObserver(MapObserver mo) {
		mapObservers.remove(mo);
	}

	public MapArea getActiveMapArea(){
		return this.activeMapArea;
	}


	/********* Forward to tile ************/
	public void addEntity(Entity entity, Position pos){
		this.activeMapArea.addEntity(entity, pos);
	}

	public void addItem(Item item, Position pos){
		this.activeMapArea.addItem(item, pos);
	}

	public void addTrap(Trap trap, Position pos){
		this.activeMapArea.addTrap(trap, pos);
	}

	public void addAE(AreaEffect ae, Position pos){
		this.activeMapArea.addAE(ae, pos);
	}

	public void removeEntity(Entity entity, Position pos){
		this.activeMapArea.removeEntity(entity, pos);
	}

	public void removeItem(Item item, Position pos){
		this.activeMapArea.removeItem(item, pos);
	}

	public void removeTrap( Position pos) { this.activeMapArea.removeTrap(pos);}

	public void removeAE(AreaEffect ae, Position pos){
		this.activeMapArea.removeAE(ae, pos);
	}


	/********* END Forward to tile ************/
}


