package com.wrathOfLoD.Controllers.InputStates.Action.AvatarActions;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.Action.ModifiableAction;
import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MoveAction extends ModifiableAction {
    private ActionCommand changeDirection;

    public MoveAction(int currKeyCode, ActionCommand myAction) {
        super(currKeyCode, myAction);
    }

    public MoveAction(int currKeyCode, ActionCommand myAction, ActionCommand changeDirection){
        super(currKeyCode, myAction);
        this.changeDirection = changeDirection;
    }
//
//    @Override
//    public void executeUp() {
//        System.out.println("Changing UP!");
//    }
//
//    @Override
//    public void executeDown() {
//        System.out.println("Changing DOWN!");
//    }
}
