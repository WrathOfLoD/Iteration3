package com.wrathOfLoD.Controllers.InputStates;

import com.sun.glass.events.KeyEvent;
import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.Action.AvatarActions.MoveAction;
import com.wrathOfLoD.Controllers.InputStates.Action.InventoryActions.ChangeSelectionAction;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionVendor {

    public static Action createMoveNorthAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand moveNorth = ActionCommandVendor.createMovementCommand(a, a.getDirection());
        ActionCommand lookNorth = ActionCommandVendor.createChangeDirectionCommand(a, Direction.NORTH);
        return new MoveAction(KeyEvent.VK_W, moveNorth, lookNorth);
    }

    public static Action createSelectUpAction(InventoryView inventoryView) {
        ActionCommand selectUpCommand = ActionCommandVendor.createSelectUpCommand(inventoryView);
        return new ChangeSelectionAction(KeyEvent.VK_W, selectUpCommand);
    }

    public static Action createSelectDownAction(InventoryView inventoryView) {
        ActionCommand selectDownCommand = ActionCommandVendor.createSelectDownCommand(inventoryView);
        return new ChangeSelectionAction(KeyEvent.VK_S, selectDownCommand);
    }

    public static Action createSelectLeftAction(InventoryView inventoryView) {
        ActionCommand selectLeftCommand = ActionCommandVendor.createSelectLeftCommand(inventoryView);
        return new ChangeSelectionAction(KeyEvent.VK_A, selectLeftCommand);
    }

    public static Action createSelectRightAction(InventoryView inventoryView) {
        ActionCommand selectRightCommand = ActionCommandVendor.createSelectRightCommand(inventoryView);
        return new ChangeSelectionAction(KeyEvent.VK_D, selectRightCommand);
    }
}
