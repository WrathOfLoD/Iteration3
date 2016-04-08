package com.wrathOfLoD.Commands.Vendors;

import com.wrathOfLoD.Commands.ActionCommand.MovementCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by luluding on 4/8/16.
 */
public class ActionCommandVendor {

    public static MovementCommand createMovementCommand(Entity e, Position pos, Direction dir, int speed){
        return new MovementCommand(e, pos, dir, speed);
    }


}
