package com.wrathOfLoD.Models.Commands.InventoryActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

/**
 * Created by zach on 4/13/16.
 */
public class SelectItemCommand extends InventorySelectCommand {

    public SelectItemCommand(InventoryView inventoryView) {
        super(inventoryView);
    }

    @Override
    public void execute() {
        this.getInventoryView().useSelectedItem();
    }
}
