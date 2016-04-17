package com.wrathOfLoD.Models.Map;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/8/16.
 */
// TODO: Not sure if TeleportTile should be a subclass of Tile
public class TeleportTile extends Tile {
    private Position newDestination;

    public TeleportTile(Position newDestination){
        this.newDestination = newDestination;
    }

    @Override
    public void interact(Entity e){
        Map.getInstance().removeEntity(e, e.getPosition());
        LocationTrackerManager.getInstance().deregisterEntity(e);

        Map.getInstance().addEntity(e, newDestination);

        // TODO: Not sure if I need to registerEntity once again!!
        LocationTrackerManager.getInstance().registerEntity(e);


    }
}
