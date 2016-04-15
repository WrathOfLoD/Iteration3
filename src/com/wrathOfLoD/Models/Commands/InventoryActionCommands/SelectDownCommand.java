package com.wrathOfLoD.Models.Commands.InventoryActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.LocationTracker.LocationTrackerManager;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Views.ItemDisplayView.InventoryView;

/**
 * Created by zach on 4/9/16.
 */
public class SelectDownCommand extends InventorySelectCommand {

    public SelectDownCommand(InventoryView inventoryView) {
        super(inventoryView);
    }

    @Override
    public void execute(){
        this.getInventoryView().selectDownItem();
    }
}
