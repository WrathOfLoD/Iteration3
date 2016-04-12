package com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Stats.Stats;


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

    /***** getter & setter for EquipItemCommand *******/

    protected EquippableItem getItem(){ return this.item; }

    /********* END Getters and Setters *********/

    protected abstract void equipHook(Equipment equipment);

    @Override
    public void execute(){
        Inventory inventory = character.getInventory();
        if(inventory.hasItem(item)){
            inventory.removeItem(item);
            Equipment equipment = character.getEquipment();
            equipHook(equipment);
            Stats characterStats = character.getStats();
            characterStats.addTemporaryStats(item.getStatsModifiable());
        }
    }
}
