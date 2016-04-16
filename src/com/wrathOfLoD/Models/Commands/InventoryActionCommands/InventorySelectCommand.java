package com.wrathOfLoD.Models.Commands.InventoryActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

/**
 * Created by zach on 4/13/16.
 */
public abstract class InventorySelectCommand extends ActionCommand {
    private InventoryView inventoryView;
    private Entity entity;

    public InventorySelectCommand(InventoryView inventoryView) {
        this.inventoryView = inventoryView;
    }

    public InventoryView getInventoryView() { return this.inventoryView; }

}
