package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionCommandVendor {

    public static ActionCommand createMovementCommand(Entity e, Direction dir){
        return new MovementCommand(e,dir);
    }

    public static ActionCommand createChangeDirectionCommand(Entity e, Direction dir){
        return new MovementCommand(e,dir);
    }
}
