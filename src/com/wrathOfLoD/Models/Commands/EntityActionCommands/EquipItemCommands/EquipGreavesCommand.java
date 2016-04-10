package com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Greaves;

/**
 * Created by matthewdiaz on 4/9/16.
 */

public class EquipGreavesCommand extends EquipItemCommand {
    public EquipGreavesCommand(Character character, Greaves greaves){
        super(character, greaves);
    }

    @Override
    protected void equipHook(Equipment equipment){
        EquippableItem item = getItem();
        equipment.equip((Greaves) item);
    }
}
