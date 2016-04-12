package com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Stats.Stats;

/**
 * Created by matthewdiaz on 4/9/16.
 */
public abstract class UnequipItemCommand extends ActionCommand{
    private Character character;
    private EquippableItem item;

    public UnequipItemCommand(Character character, EquippableItem item){
        this.character = character;
        this.item = item;
    }

    /***** getter & setter for EquipItemCommand *******/

    protected EquippableItem getItem(){ return this.item; }


    /********* END Getters and Setters *********/

    protected abstract boolean unequipHook(Equipment equipment);

    @Override
    public void execute(){
        Equipment equipment = character.getEquipment();
        if(unequipHook(equipment)){
            character.insertItemToInventory(item);

            Stats characterStats = character.getStats();
            characterStats.removeTemporaryStats(item.getStatsModifiable());
        }
    }
}
