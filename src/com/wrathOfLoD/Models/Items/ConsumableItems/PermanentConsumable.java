package com.wrathOfLoD.Models.Items.ConsumableItems;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands.ConsumePermanentItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class PermanentConsumable extends ConsumableItem {
    public PermanentConsumable(String name, StatsModifiable stats){
        super(name, stats);
    }

    @Override
    protected void consume(Character character){
        ActionCommand consumePermanentItemCommand = new ConsumePermanentItemCommand(character, this);
        consumePermanentItemCommand.execute();
    }

    public void accept(ItemVisitor iv){
        iv.visitPermanentConsumable(this);
    }
}
