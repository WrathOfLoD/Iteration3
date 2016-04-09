package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.MovementCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionCommandVendor {

    public static ActionCommand createMovementCommand(Entity e, Direction dir){
        //return new MovementCommand(e,dir);
        return null;
    }

    public static ActionCommand createChangeDirectionCommand(Entity e, Direction dir){
        return new MovementCommand(e,e.getPosition(), e.getDirection(), 0); //change dir has speed?
    }

    public static ActionCommand createMovementCommand(Entity e, Position pos, Direction dir, int speed){
        return new MovementCommand(e, pos, dir, speed);
    }
}
