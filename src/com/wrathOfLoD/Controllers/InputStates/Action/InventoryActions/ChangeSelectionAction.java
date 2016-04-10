package com.wrathOfLoD.Controllers.InputStates.Action.InventoryActions;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.event.KeyEvent;

/**
 * Created by zach on 4/9/16.
 */
public class ChangeSelectionAction extends Action {
    public ChangeSelectionAction(int currKeyCode, ActionCommand myAction) {
        super(currKeyCode, myAction);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
