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
    private List<Entity> entityList;
    private Map<Entity, Position> entityPositionMap;
    private List<Item> itemList;
    private Map<Entity, TargetManager> entityTargetManagerMap;

    public LocationTracker() {
        this.entityList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        this.entityTargetManagerMap = new HashMap<Entity, TargetManager>();
    }

    private void updateTargetManager(List<Entity> eList, List<Item> iList) {}

    public void registerItem(Item item) {
        itemList.add(item);
    }
    public void deregisterItem(Item item) {
        itemList.remove(item);
    }

    public void registerEntity(Entity e) {
        this.entityList.add(e);

    }

    public void deregisterEntity(Entity e) {
        this.entityList.remove(e);
    }

    public void updateLocation(Entity e) {
        TargetManager entityTargetManager = this.entityTargetManagerMap.get(e);

        // iterate over entitiyies list
        //  make sure you dont look at yourself
        //  for all entities within your TM's range, add them to your TM
        for (Entity entity : this.entityList) {

        }
    }
}

