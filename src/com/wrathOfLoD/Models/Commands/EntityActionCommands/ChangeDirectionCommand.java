package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ChangeDirectionCommand extends ActionCommand {
    private Entity e;
    private Direction dir;

    public ChangeDirectionCommand(Entity e, Direction dir){
        this.e = e;
        this.dir = dir;
    }

    @Override
    public void execute() {

    }

    public Direction getDirection() {
        return this.dir;
    }

    public void setDirection(Direction dir) {
        this.dir = dir;
    }
}
