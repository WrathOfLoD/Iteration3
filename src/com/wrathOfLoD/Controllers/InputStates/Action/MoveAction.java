package com.wrathOfLoD.Controllers.InputStates.Action;

import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.event.KeyEvent;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MoveAction extends Action {
    private ActionCommand changeDirection;

    public MoveAction(KeyEvent currKeyCode, ActionCommand myAction) {
        super(currKeyCode, myAction);
    }

    public MoveAction(KeyEvent currKeyCode, ActionCommand myAction, ActionCommand changeDirection){
        super(currKeyCode, myAction);
        this.changeDirection = changeDirection;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        changeDirection.execute();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
