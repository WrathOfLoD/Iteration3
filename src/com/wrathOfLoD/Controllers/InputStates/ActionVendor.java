package com.wrathOfLoD.Controllers.InputStates;

import com.sun.glass.events.KeyEvent;
import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.Action.AvatarActions.MoveAction;
import com.wrathOfLoD.Controllers.InputStates.Action.InventoryActions.ChangeSelectionAction;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.ChangeDirectionCommand;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionVendor {

    // TODO: 4/12/16 ASK IAN WHY a.getDirection() was used
    public static Action createMoveNorthAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.NORTH);
        ChangeDirectionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.NORTH);
        return new MoveAction(KeyEvent.VK_W, move, look);
    }
    public static Action createMoveNorthEastAction(){
        Avatar a = Avatar.getInstance();
//        ActionCommand move = ActionCommandVendor.createMovementCommand(a, a.getDirection());
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.NORTH_EAST);
        ActionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.NORTH_EAST);
        return new MoveAction(KeyEvent.VK_E, move, look);
    }
    public static Action createMoveNorthWestAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.NORTH_WEST);
        ActionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.NORTH_WEST);
        return new MoveAction(KeyEvent.VK_Q, move, look);
    }
    public static Action createMoveSouthAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.SOUTH);
        ActionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.SOUTH);
        return new MoveAction(KeyEvent.VK_S, move, look);
    }
    public static Action createMoveSouthEastAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.SOUTH_EAST);
        ActionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.SOUTH_EAST);
        return new MoveAction(KeyEvent.VK_D, move, look);
    }
    public static Action createMoveSouthWestAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.SOUTH_WEST);
        ActionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.SOUTH_WEST);
        return new MoveAction(KeyEvent.VK_A, move, look);
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
