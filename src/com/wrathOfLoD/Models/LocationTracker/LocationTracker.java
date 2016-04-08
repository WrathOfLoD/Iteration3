package com.wrathOfLoD.Models.LocationTracker;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.Item;
import com.wrathOfLoD.Models.Target.Target;
import com.wrathOfLoD.Models.Target.TargetManager;

import java.util.List;

/**
 * Created by zach on 4/7/16.
 */
public class LocationTracker {
    private List<Entity> entityList;
    private List<Item> itemList;

    public LocationTracker() {}

    private void updateTargetManager(List<Entity> eList, List<Item> iList) {}

    public void registerItem() {}
    public void deregisterItem(Item item) {}

    public void registerEntity(Entity e, TargetManager tm) {}
    public void deregisterEntity(Entity e) {}

    public void updateLocation(Entity e) {}
}

