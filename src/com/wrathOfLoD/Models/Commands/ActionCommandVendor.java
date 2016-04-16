package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.ChangeDirectionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.MovementCommand;
import com.wrathOfLoD.Models.Commands.SelectableActionCommands.*;
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
}
