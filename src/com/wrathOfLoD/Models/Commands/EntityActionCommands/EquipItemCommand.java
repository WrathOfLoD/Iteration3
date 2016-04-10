package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public abstract class EquipItemCommand extends ActionCommand {
    private Character character;
    private EquippableItem item;

    public EquipItemCommand(Character character, EquippableItem item){
        this.character = character;
        this.item = item;
    }

    public abstract void equipHook(Equipment equipment);

    @Override
    public void execute(){
        Inventory inventory = character.getInventory();
        Equipment equipment = character.getEquipment();
        if(inventory.removeItem(item)){
           equipHook(equipment);
        }
    }

    protected EquippableItem getItem(){
        return this.item;
    }

}
