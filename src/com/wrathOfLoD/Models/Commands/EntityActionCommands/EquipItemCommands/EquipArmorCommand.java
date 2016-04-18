package com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.TakeableItem;


/**
 * Created by matthewdiaz on 4/9/16.
 */
public class EquipArmorCommand extends EquipItemCommand {
    public EquipArmorCommand(Character character, Armor armor){
        super(character,armor);
    }

    @Override
    protected TakeableItem equipHook(Equipment equipment){
        EquippableItem item = getItem();
        return equipment.equip((Armor) item);
    }
}
