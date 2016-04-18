package com.wrathOfLoD.Controllers.InputStates;

import com.sun.glass.events.KeyEvent;
import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.Action.AvatarActions.CastAbilityAction;
import com.wrathOfLoD.Controllers.InputStates.Action.AvatarActions.MoveAction;
import com.wrathOfLoD.Controllers.InputStates.Action.InventoryActions.ChangeSelectionAction;
import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.ActionCommandVendor;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.ChangeDirectionCommand;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;
import com.wrathOfLoD.Views.Selectable;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionVendor {

    // TODO: 4/12/16 ASK IAN WHY a.getDirection() was used

    /* Actions related to Avatar movement */
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
        ChangeDirectionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.NORTH_EAST);
        return new MoveAction(KeyEvent.VK_E, move, look);
    }
    public static Action createMoveNorthWestAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.NORTH_WEST);
        ChangeDirectionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.NORTH_WEST);
        return new MoveAction(KeyEvent.VK_Q, move, look);
    }
    public static Action createMoveSouthAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.SOUTH);
        ChangeDirectionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.SOUTH);
        return new MoveAction(KeyEvent.VK_S, move, look);
    }
    public static Action createMoveSouthEastAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.SOUTH_EAST);
        ChangeDirectionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.SOUTH_EAST);
        return new MoveAction(KeyEvent.VK_D, move, look);
    }
    public static Action createMoveSouthWestAction(){
        Avatar a = Avatar.getInstance();
        ActionCommand move = ActionCommandVendor.createMovementCommand(a, Direction.SOUTH_WEST);
        ChangeDirectionCommand look = ActionCommandVendor.createChangeDirectionCommand(a, Direction.SOUTH_WEST);
        return new MoveAction(KeyEvent.VK_A, move, look);
    }

    /* Action related to Avatar Ability */
    public static Action createFirstAbility(Ability ability){
        ActionCommand firstAbilityCommand = ActionCommandVendor.createCastAbilityCommand(ability);
        return new CastAbilityAction(KeyEvent.VK_1, firstAbilityCommand);
    }

    public static Action createSecondAbility(Ability ability){
        ActionCommand secondAbilityCommand = ActionCommandVendor.createCastAbilityCommand(ability);
        return new CastAbilityAction(KeyEvent.VK_2, secondAbilityCommand);
    }

    public static Action createThirdAbility(Ability ability){
        ActionCommand thirdAbilityCommand = ActionCommandVendor.createCastAbilityCommand(ability);
        return new CastAbilityAction(KeyEvent.VK_3, thirdAbilityCommand);
    }

    public static Action createFourthAbility(Ability ability){
        ActionCommand fourthAbilityCommand = ActionCommandVendor.createCastAbilityCommand(ability);
        return new CastAbilityAction(KeyEvent.VK_4, fourthAbilityCommand);
    }

    public static Action createFifthAbility(Ability ability){
        ActionCommand fifthAbilityCommand = ActionCommandVendor.createCastAbilityCommand(ability);
        return new CastAbilityAction(KeyEvent.VK_5, fifthAbilityCommand);
    }

    public static Action createSixthAbility(Ability ability){
        ActionCommand sixthAbilityCommand = ActionCommandVendor.createCastAbilityCommand(ability);
        return new CastAbilityAction(KeyEvent.VK_6, sixthAbilityCommand);
    }



    /* Actions related to menu/inventory selection */
    public static Action createSelectUpAction(Selectable selectable) {
        ActionCommand selectUpCommand = ActionCommandVendor.createSelectUpCommand(selectable);
        return new ChangeSelectionAction(KeyEvent.VK_W, selectUpCommand);
    }

    public static Action createSelectDownAction(Selectable selectable) {
        ActionCommand selectDownCommand = ActionCommandVendor.createSelectDownCommand(selectable);
        return new ChangeSelectionAction(KeyEvent.VK_S, selectDownCommand);
    }

    public static Action createSelectLeftAction(Selectable selectable) {
        ActionCommand selectLeftCommand = ActionCommandVendor.createSelectLeftCommand(selectable);
        return new ChangeSelectionAction(KeyEvent.VK_A, selectLeftCommand);
    }

    public static Action createSelectRightAction(Selectable selectable) {
        ActionCommand selectRightCommand = ActionCommandVendor.createSelectRightCommand(selectable);
        return new ChangeSelectionAction(KeyEvent.VK_D, selectRightCommand);
    }
    public static Action createSelectItemAction(Selectable selectable) {
        ActionCommand selectItemCommand = ActionCommandVendor.createSelectItemCommand(selectable);
        return new ChangeSelectionAction(KeyEvent.VK_ENTER, selectItemCommand);
    }

    public static Action createOpenInventoryAction(Entity entity) {
        ActionCommand openInventoryCommand = ActionCommandVendor.createOpenInventoryCommand(entity);
        return new Action(KeyEvent.VK_I, openInventoryCommand);
    }

    public static Action createRevertToAvatarStateAction() {
        ActionCommand revertToAvatarStateCommand= ActionCommandVendor.createRevertToAvatarStateCommand();
        return new Action(KeyEvent.VK_ESCAPE, revertToAvatarStateCommand);
    }

    public static Action createSwitchToEquipmentStateAction(Character c) {
        ActionCommand switchToEquipmentStateAction = ActionCommandVendor.createSwitchToEquipmentStateAction(c);
        return new Action(KeyEvent.VK_SPACE, switchToEquipmentStateAction);
    }

    public static Action createMountAction(Character c) {
        ActionCommand mountCommand = ActionCommandVendor.createMountCommand(c);
        return new Action(KeyEvent.VK_M, mountCommand);
    }
}
