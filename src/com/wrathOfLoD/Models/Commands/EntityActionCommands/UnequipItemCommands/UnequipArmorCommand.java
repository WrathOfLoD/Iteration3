package com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public class UnequipArmorCommand extends UnequipItemCommand{
    public UnequipArmorCommand(Character character, Armor armor){
        super(character,armor);
    }

    @Override
    protected boolean unequipHook(Equipment equipment){
        EquippableItem item = getItem();
        return equipment.unequip((Armor) item);
    }

}
