package com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.ConsumableItems.ConsumableItem;

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

}
