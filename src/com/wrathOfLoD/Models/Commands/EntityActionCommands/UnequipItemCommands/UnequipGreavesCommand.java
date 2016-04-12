package com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Greaves;

/**
 * Created by matthewdiaz on 4/9/16.
 */

public class UnequipGreavesCommand extends UnequipItemCommand{
    public UnequipGreavesCommand(Character character, Greaves greaves){
        super(character, greaves);
    }

    @Override
    protected boolean unequipHook(Equipment equipment){
        EquippableItem item = getItem();
        return equipment.unequip((Greaves) item);
    }
}
