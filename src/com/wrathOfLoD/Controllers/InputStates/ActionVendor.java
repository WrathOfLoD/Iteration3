package com.wrathOfLoD.Controllers.InputStates;

import com.sun.glass.events.KeyEvent;
import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.Action.MoveAction;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Avatar;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionVendor {

    public static Action createMoveNorthAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand moveNorth = ActionCommandVendor.createMovementCommand(a, a.getDirection());
        ActionCommand lookNorth = ActionCommandVendor.createChangeDirectionCommand(a,a.getDirection());
        return new MoveAction(KeyEvent.VK_W, moveNorth, lookNorth);
    }
}
