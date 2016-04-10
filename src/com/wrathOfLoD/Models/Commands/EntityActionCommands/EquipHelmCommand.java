package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;

/**
 * Created by matthewdiaz on 4/9/16.
 */

public class EquipHelmCommand extends EquipItemCommand{
    public EquipHelmCommand(Character character, Helm helm){
        super(character, helm);
    }

    //Is this cast ok??!!!
    public void equipHook(Equipment equipment){
        EquippableItem item = getItem();
        equipment.equip((Helm) item);
    }
}
