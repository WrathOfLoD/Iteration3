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
        this.activeLocationTracker = null;
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
    public void registerLocationTracker(LocationTracker locationTracker, MapArea mapArea) {
        this.locTrackerMap.put(mapArea, locationTracker);
    }

    public void registerItem(Item item) {
        this.activeLocationTracker.registerItem(item);
    }
    public void deregisterItem(Item item) {
        this.activeLocationTracker.deregisterItem(item);
    }

    public void registerEntity(Entity e, TargetManager tm) {}
    public void deregisterEntity(Entity e) {}

    public void updateLocation(Entity e) {
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
