package com.wrathOfLoD.Models.LocationTracker;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Map.MapArea;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zach on 4/7/16.
 */
public class LocationTrackerManager {
    private static LocationTrackerManager instance = null;

    private Map<MapArea, LocationTracker> locTrackerMap;
    private LocationTracker activeLocationTracker;

    protected LocationTrackerManager() {
        this.locTrackerMap = new HashMap<MapArea, LocationTracker>();
        this.activeLocationTracker = null; //TODO nothing ever sets this to non-null
    }

    /**
     * @desc Used to return our singleton or initialize it if not yet initialized
     * @return singleton instance of LocationTrackerManager
     */
    public static LocationTrackerManager getInstance() {
        if (instance == null) {
            instance = new LocationTrackerManager();
        }
        return instance;
    }

    /**
     * @desc Register location trackers on a map area
     * @param locationTracker - LocationTracker
     * @param mapArea - MapArea
     */
	//TODO this method is never called
    public void registerLocationTracker(LocationTracker locationTracker, MapArea mapArea) {
        this.locTrackerMap.put(mapArea, locationTracker);
    }

    public void registerItem(Item item, Position pos) {
        this.activeLocationTracker.registerItem(item, pos);
    }
    public void deregisterItem(Item item) {
        this.activeLocationTracker.deregisterItem(item);
    }

    public void registerEntity(Entity e, TargetManager tm) {}
    public void registerEntity(Entity e){
        activeLocationTracker.registerEntity(e);
    }
    public void deregisterEntity(Entity e) {
        activeLocationTracker.deregisterEntity(e);
    }

    public void updateLocation(Entity e) {
		System.out.println("num of location trackers in hash map: " + this.locTrackerMap.values().size());
		System.out.println("is active location tracker null? " + (this.activeLocationTracker == null));
		this.activeLocationTracker.updateLocation(e);
    }
    public void updateLocation(Item i, Position position) {
        this.activeLocationTracker.updateLocation(i, position);
    }

    public void updateActiveMapArea(MapArea newActiveMapArea) {
        this.setActiveLocationTracker(this.locTrackerMap.get(newActiveMapArea));
    }

    public void setActiveLocationTracker(LocationTracker lt) {
        this.activeLocationTracker = lt;
    }
}
