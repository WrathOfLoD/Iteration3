package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.*;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.MeleeAttackCommand;
import com.wrathOfLoD.Models.Commands.SelectableActionCommands.*;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Views.Selectable;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionCommandVendor {

    // TODO: 4/12/16 ASK IAN ABOUT THIS AS WELL
    public static ChangeDirectionCommand createChangeDirectionCommand(Entity e, Direction dir){
        return new ChangeDirectionCommand(e, dir);
    }

    public static ActionCommand createMovementCommand(Entity e, Direction dir){
        return new MovementCommand(e, dir);
    }
    public static ActionCommand createFallCommand(Entity e, int distToFall){
        return new FallCommand(e, distToFall);
    }
    public static ActionCommand createFlyCommand(Entity e, Direction dir){return new FlyingCommand(e,dir);}

    public static ActionCommand createSelectUpCommand(Selectable selectable) {
        return new SelectUpCommand(selectable);
    }
    public static ActionCommand createSelectDownCommand(Selectable selectable) {
        return new SelectDownCommand(selectable);
    }
    public static ActionCommand createSelectLeftCommand(Selectable selectable) {
        return new SelectLeftCommand(selectable);
    }
    public static ActionCommand createSelectRightCommand(Selectable selectable) {
        return new SelectRightCommand(selectable);
    }
    public static ActionCommand createSelectItemCommand(Selectable selectable) {
        return new SelectItemCommand(selectable);
    }

    public static ActionCommand createCastAbilityCommand(Ability ability){
        return new CastAbilityCommand(ability);
    }

    public static ActionCommand createOpenInventoryCommand(Entity e) {
        return new OpenInventoryCommand(e);
    }

    public static ActionCommand createRevertToAvatarStateCommand() {
        return new RevertToAvatarStateCommand();
    }

    public static ActionCommand createSwitchToEquipmentStateAction(Character c) {
        return new SwitchToEquipmentStateCommand(c);
    }

    public static ActionCommand createMountCommand(Character c) {
        return new MountCommand(c);
    }

    public static void createAttackCommand(Character c) { c.attack(); }
}
