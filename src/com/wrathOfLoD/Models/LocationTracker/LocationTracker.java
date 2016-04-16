package com.wrathOfLoD.Models.LocationTracker;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Target.EntityTarget;
import com.wrathOfLoD.Models.Target.ItemTarget;
import com.wrathOfLoD.Models.Target.Target;
import com.wrathOfLoD.Models.Target.TargetManager;
import com.wrathOfLoD.Utility.Position;

import java.util.*;

/**
 * Created by zach on 4/7/16.
 */
public class LocationTracker {
    // TODO: 4/9/16 We may not use the lists and use the Maps with Position instead
    private List<Entity> entityList;
//    private List<Item> itemList;

    // Mapping of Entities/Items on the map area and their current position
//    private Map<Entity, Position> entityPositionMap;
    private Map<Item, Position> itemPositionMap;

    // Map of all Entities and their respective target managers
    private Map<Entity, TargetManager> entityTargetManagerMap;

    public LocationTracker() {
        // TODO: 4/9/16 We may not use the lists and use the Maps with Position instead
        this.entityList = new ArrayList<>();
//        this.itemList = new ArrayList<>();

        this.entityTargetManagerMap = new HashMap<Entity, TargetManager>();
//        this.entityPositionMap= new HashMap<Entity, Position>();
        this.itemPositionMap = new HashMap<Item, Position>();
    }


    private void updateTargetManager(List<Entity> eList, List<Item> iList) {}

    /**
     * @desc Register an item to track
     * @param item - Item to be tracked
//     * @param position - Current position
     */
    // TODO: 4/9/16 MAY NEED TO ADD A POSITION TO THIS
    public void registerItem(Item item, Position pos) {
        this.itemPositionMap.put(item, pos);
//        this.itemList.add(item);
        for(Entity e : entityList){
            if(pos.getHorizontalDist(e.getPosition()) < 8){
                TargetManager targManager = entityTargetManagerMap.get(e);
                targManager.updateMyList(new ItemTarget(item, pos));
            }
        }
    }

    public void deregisterItem(Item item) {
        Position currentItemPos = itemPositionMap.get(item);
        for(Entity e : entityList){
            if(currentItemPos.getHorizontalDist(e.getPosition()) < 8){
                TargetManager targMngr = entityTargetManagerMap.get(e);
                targMngr.deregisterItem(item);
            }
        }
        itemPositionMap.remove(item);
//        itemList.remove(item);
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
        entityTargetManagerMap.put(entity, entity.getTargetManager());
    }

    public void deregisterEntity(Entity entity) {
        Position pos = entity.getPosition();
        for(Entity e : entityList){
            if(pos.getHorizontalDist(e.getPosition()) < 8){
                TargetManager targMngr = entityTargetManagerMap.get(e);
                targMngr.deregisterEntity(entity);
            }
        }
        this.entityList.remove(entity);
        entityTargetManagerMap.remove(entity);
    }


    /**
     * @desc Handle updates to entity locations, update their TargetManager
     * @param entity - Item to be tracked
//     * @param position - Current position
     */
    public void updateLocation(Entity entity) {
        // TODO: 4/15/16 Need to do this for *every* target manager within our entityTargetManagerMap
        //      This is so that entities that aren't moving still get updates from other entities

        TargetManager entityTargetManager = this.entityTargetManagerMap.get(entity);

        // Iterate over Entity list
        //  make sure you dont look at yourself
        //  for all entities within your TM's range, add them to your TM

        Position current = entity.getPosition();
        EntityTarget movingEntity = new EntityTarget(entity);
        for (Entity e : this.entityList) {
            if(!e.equals(entity)){
                int dist = current.getHorizontalDist(e.getPosition());
                if(dist < 8){
                    TargetManager targManger = entityTargetManagerMap.get(e);
                    targManger.updateMyList(movingEntity);
                    entityTargetManager.updateMyList(new EntityTarget(e));
                }
            }
        }
        Iterator it = itemPositionMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            Item curr = (Item) pair.getKey();
            Position itemPos = (Position) pair.getValue();
            if(current.getHorizontalDist(itemPos) < 8){
                entityTargetManager.updateMyList(new ItemTarget(curr, itemPos));
            }
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

