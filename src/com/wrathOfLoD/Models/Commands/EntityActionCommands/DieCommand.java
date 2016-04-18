package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;

/**
 * Created by matthewdiaz on 4/8/16.
 */
public class DieCommand  extends ActionCommand {
    private Entity entity;

    public DieCommand(Entity entity){
        this.entity = entity;
    }
    @Override
    public void execute() {
        // Remove entity from the LTM

        Map.getInstance().removeEntity(entity,entity.getPosition());
        //LocationTrackerManager.getInstance().deregisterEntity(entity);

        entity.setDead(true);
        entity.setInactive();

    }
}
