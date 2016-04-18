package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class PickUpItemCommand extends ActionCommand implements Fuseable{
    private TakeableItem item;
    private Entity entity;

    public PickUpItemCommand(Entity entity, TakeableItem item){
        this.entity = entity;
        this.item = item;
    }

    @Override
    public void execute(){
        TimeModel.getInstance().registerFuseable(this, 2);
    }

    @Override
    public void explode() {
        Map.getInstance().removeItem(item, entity.getPosition());
        LocationTrackerManager.getInstance().deregisterItem(item);

        // Remove item from the LTM
        //LocationTrackerManager.getInstance().deregisterItem(item); //TODO: comment back, this is break things

        entity.insertItemToInventory(item);
    }
}
