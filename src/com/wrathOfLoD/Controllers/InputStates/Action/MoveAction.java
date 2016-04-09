package com.wrathOfLoD.Controllers.InputStates.Action;

import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MoveAction extends Action {
    private ActionCommand changeDirection;

    public MoveAction(int currKeyCode, ActionCommand myAction) {
        super(currKeyCode, myAction);
    }

    public MoveAction(int currKeyCode, ActionCommand myAction, ActionCommand changeDirection){
        super(currKeyCode, myAction);
        this.changeDirection = changeDirection;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == getCurrCode() && listenting()){
            changeDirection.execute();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
