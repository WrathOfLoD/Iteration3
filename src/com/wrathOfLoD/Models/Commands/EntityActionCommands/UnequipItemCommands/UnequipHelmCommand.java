package com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;

/**
 * Created by matthewdiaz on 4/9/16.
 */

public class UnequipHelmCommand extends UnequipItemCommand{
    public UnequipHelmCommand(Character character, Helm helm){
        super(character, helm);
    }

    @Override
    protected boolean unequipHook(Equipment equipment){
        EquippableItem item = getItem();
        return equipment.unequip((Helm) item);
    }
}
