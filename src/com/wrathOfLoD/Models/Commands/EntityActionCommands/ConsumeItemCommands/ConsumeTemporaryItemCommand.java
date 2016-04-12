package com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands;

import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.ConsumableItems.PermanentConsumable;

/**
 * Created by matthewdiaz on 4/12/16.
 */
public class ConsumeTemporaryItemCommand extends ConsumeItemCommand {
    public ConsumeTemporaryItemCommand(Entity entity, PermanentConsumable permanentConsumable){
        super(entity, permanentConsumable);
    }

    public void execute(){}
}
