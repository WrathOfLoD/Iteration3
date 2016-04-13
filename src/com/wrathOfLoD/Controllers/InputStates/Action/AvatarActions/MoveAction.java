package com.wrathOfLoD.Controllers.InputStates.Action.AvatarActions;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.Action.ModifiableAction;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.ChangeDirectionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.MovementCommand;
import com.wrathOfLoD.Utility.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MoveAction extends ModifiableAction {
    private ChangeDirectionCommand changeDirection;

    public MoveAction(int currKeyCode, ActionCommand myAction) {
        super(currKeyCode, myAction);
    }

    public MoveAction(int currKeyCode, ActionCommand myAction, ChangeDirectionCommand changeDirection){
        super(currKeyCode, myAction);
        this.changeDirection = changeDirection;
    }
//
    @Override
    public void executeUp() {
        System.out.println("Changing UP!");
        Direction dir = this.changeDirection.getDirection();
        dir = dir.above();
        this.changeDirection.setDirection(dir);
        this.changeDirection.execute();
    }

    @Override
    public void executeDown() {
        System.out.println("Changing DOWN!");
        Direction dir = this.changeDirection.getDirection();
        dir = dir.below();
        this.changeDirection.setDirection(dir);
        this.changeDirection.execute();
    }
}
