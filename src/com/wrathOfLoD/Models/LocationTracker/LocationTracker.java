package com.wrathOfLoD.Models.LocationTracker;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Target.Target;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zach on 4/7/16.
 */
public class LocationTracker {
    // TODO: 4/9/16 We may not use the lists and use the Maps with Position instead
    private List<Entity> entityList;
    private List<Item> itemList;

    // Mapping of Entities/Items on the map area and their current position
    private Map<Entity, Position> entityPositionMap;
    private Map<Item, Position> itemPositionMap;

    // Map of all Entities and their respective target managers
    private Map<Entity, TargetManager> entityTargetManagerMap;

    public LocationTracker() {
        // TODO: 4/9/16 We may not use the lists and use the Maps with Position instead
        this.entityList = new ArrayList<>();
        this.itemList = new ArrayList<>();

        this.entityTargetManagerMap = new HashMap<Entity, TargetManager>();
        this.entityPositionMap= new HashMap<Entity, Position>();
        this.itemPositionMap = new HashMap<Item, Position>();
    }


    private void updateTargetManager(List<Entity> eList, List<Item> iList) {}

    /**
     * @desc Register an item to track
     * @param item - Item to be tracked
//     * @param position - Current position
     */
    // TODO: 4/9/16 MAY NEED TO ADD A POSITION TO THIS
    public void registerItem(Item item) {
//        this.itemPositionMap.add(item, position);
        this.itemList.add(item);
    }

    public void deregisterItem(Item item) {
        itemList.remove(item);
    }


    /**
     * @desc Register an entity to track
     * @param entity - Entity to be tracked
//     * @param position - Current position
     */
    // TODO: 4/9/16 MAY NEED TO ADD A POSITION TO THIS
    public void registerEntity(Entity entity) {
//        this.entityPositionMap.put(entity, position);
        this.entityList.add(entity);
    }

    public void deregisterEntity(Entity entity) {
        this.entityList.remove(entity);
    }


    /**
     * @desc Handle updates to entity locations, update their TargetManager
     * @param entity - Item to be tracked
//     * @param position - Current position
     */
    public void updateLocation(Entity entity) {
        TargetManager entityTargetManager = this.entityTargetManagerMap.get(entity);

        // Iterate over Entity list
        //  make sure you dont look at yourself
        //  for all entities within your TM's range, add them to your TM
        for (Entity e : this.entityList) {

        }
    }

    /**
     * @desc Handle updates to entity locations, update their TargetManager
     * @param item - Item to be tracked
     * @param position - Current position
     */
    public void updateLocation(Item item, Position position) {
        this.itemPositionMap.put(item, position);
    }
}

