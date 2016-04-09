package com.wrathOfLoD.Commands.ActionCommand;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.LocationTracker.LocationTracker;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class PickUpItemCommand extends ActionCommand {
    private TakeableItem item;

    public PickUpItemCommand(Entity entity, TakeableItem item){
        super(entity);
        this.item = item;
    }

    @Override
    public void execute(){
        Map map = Map.getInstance();
        Entity entity = getEntity();
        Position position = entity.getPosition();

        Tile tile = map.getTile(position);
        tile.removeItem(item);

        // Remove item from the LTM
        LocationTrackerManager.getInstance().deregisterItem(item);

        entity.pickUpItem(item);
    }
}
