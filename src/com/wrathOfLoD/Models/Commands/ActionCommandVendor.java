package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.ChangeDirectionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.MovementCommand;
import com.wrathOfLoD.Models.Commands.InventoryActionCommands.*;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

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

    public static ActionCommand createSelectUpCommand(InventoryView inventoryView) {
        return new SelectUpCommand(inventoryView);
    }
    public static ActionCommand createSelectDownCommand(InventoryView inventoryView) {
        return new SelectDownCommand(inventoryView);
    }
    public static ActionCommand createSelectLeftCommand(InventoryView inventoryView) {
        return new SelectLeftCommand(inventoryView);
    }
    public static ActionCommand createSelectRightCommand(InventoryView inventoryView) {
        return new SelectRightCommand(inventoryView);
    }
    public static ActionCommand createSelectItemCommand(InventoryView inventoryView) {
        return new SelectItemCommand(inventoryView);
    }
}
