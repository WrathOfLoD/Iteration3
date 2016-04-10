package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.MovementCommand;
import com.wrathOfLoD.Models.Commands.InventoryActionCommands.SelectDownCommand;
import com.wrathOfLoD.Models.Commands.InventoryActionCommands.SelectLeftCommand;
import com.wrathOfLoD.Models.Commands.InventoryActionCommands.SelectRightCommand;
import com.wrathOfLoD.Models.Commands.InventoryActionCommands.SelectUpCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

/**
 * Created by icavitt on 4/7/2016.
 */
public class ActionCommandVendor {

    public static ActionCommand createChangeDirectionCommand(Entity e, Direction dir){
        return new MovementCommand(e, dir);
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
}
