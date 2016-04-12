package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Inventory.Inventory;

/**
 * Created by zach on 4/9/16.
 */
public class InventoryState extends InputState {
    private Inventory inventory;

    public InventoryState(Inventory inventory) {
        this.inventory = inventory;

        this.setActiveActionSet(inventory.getActionSet());
    }
}
