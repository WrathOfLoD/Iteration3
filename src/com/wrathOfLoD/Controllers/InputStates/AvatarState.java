package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Direction;

/**
 * Created by icavitt on 4/7/2016.
 */
public class AvatarState extends InputState{
    public AvatarState(){
        //adds the moveNorth action to its list of actions
        addNewAction(ActionVendor.createMoveNorthAction());
    }
}
