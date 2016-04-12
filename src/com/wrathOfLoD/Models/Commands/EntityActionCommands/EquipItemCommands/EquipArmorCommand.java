package com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;


/**
 * Created by matthewdiaz on 4/9/16.
 */
public class EquipArmorCommand extends EquipItemCommand {
    public EquipArmorCommand(Character character, Armor armor){
        super(character,armor);
    }

    @Override
    protected void equipHook(Equipment equipment){
        EquippableItem item = getItem();
        equipment.equip((Armor) item);
    }
}
