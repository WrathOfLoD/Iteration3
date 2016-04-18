package com.wrathOfLoD.Models.Commands;

import com.wrathOfLoD.Controllers.InputStates.InventoryState;
import com.wrathOfLoD.Controllers.MainController;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

/**
 * Created by zach on 4/18/16.
 */
public class OpenInventoryCommand extends ActionCommand {
    private Inventory inv;

    public OpenInventoryCommand(Entity e) {
        this.inv = e.getInventory();
    }

    @Override
    public void execute() {
        MainController.getInstance().setActiveState(new InventoryState(inv));
        System.out.println("IES VIEW: " );
        System.out.println(ViewManager.getInstance().getAvatarIESView());
        ViewManager.getInstance().addView(ViewManager.getInstance().getAvatarIESView());
    }
}
