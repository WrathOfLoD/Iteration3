package com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.TakeableItem;

/**
 * Created by matthewdiaz on 4/9/16.
 */

public class EquipHelmCommand extends EquipItemCommand {
    public EquipHelmCommand(Character character, Helm helm){
        super(character, helm);
    }

    @Override
    protected TakeableItem equipHook(Equipment equipment){
        EquippableItem item = getItem();
        System.out.println("ADDING " + item.getName() + " to equipment:");
        System.out.println(equipment);
        return equipment.equip((Helm) item);
    }
}
