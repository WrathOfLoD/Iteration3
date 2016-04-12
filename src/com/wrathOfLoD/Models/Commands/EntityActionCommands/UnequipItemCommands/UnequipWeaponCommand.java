package com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;

/**
 * Created by matthewdiaz on 4/9/16.
 */

public class  UnequipWeaponCommand extends UnequipItemCommand{
    public  UnequipWeaponCommand(Character character, Weapon weapon){
        super(character, weapon);
    }

    @Override
    protected boolean unequipHook(Equipment equipment){
        EquippableItem item = getItem();
        return equipment.unequip((Weapon) item);
    }
}
