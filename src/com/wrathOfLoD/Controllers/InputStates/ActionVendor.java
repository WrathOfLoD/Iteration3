package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Avatar;

/**
 * Created by icavitt on 4/7/2016.
 */
class ActionVendor {

    public static Action createMoveNorthAction(){
        ActionCommandVendor.createMovementCommand(Avatar.getInstance(), Avatar.)
    }
}
