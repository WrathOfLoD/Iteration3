package com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.ConsumableItems.ConsumableItem;
import com.wrathOfLoD.Models.Items.ConsumableItems.TemporaryConsumable;
import com.wrathOfLoD.Models.Stats.Stats;

/**
 * Created by matthewdiaz on 4/12/16.
 */
public abstract class ConsumeItemCommand extends ActionCommand{
    private ConsumableItem item;
    private Entity entity;

    public ConsumeItemCommand(Entity entity, ConsumableItem item){
        this.entity = entity;
        this.item = item;
    }

    /***** getter & setter for EquipItemCommand *******/
    protected ConsumableItem getItem(){
        return item;
    }

    protected Entity getEntity(){
        return entity;
    }

    protected abstract void hook(Stats entityStats, ConsumableItem item);

    /********* END Getters and Setters *********/

    public void execute(){
        Entity entity = getEntity();
        Inventory inventory = entity.getInventory();
        ConsumableItem item = getItem();
        TemporaryConsumable temporaryConsumable = ((TemporaryConsumable) getItem());

        if(inventory.hasItem(item)){
            Stats entityStats = entity.getStats();
            hook(entityStats, item);
            inventory.removeItem(temporaryConsumable);
        }
    }
}
