package com.wrathOfLoD.Models.Items.ConsumableItems;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands.ConsumePermanentItemCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands.ConsumeTemporaryItemCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class TemporaryConsumable extends ConsumableItem {
    private int timeEffect;
    public TemporaryConsumable(String name, StatsModifiable stats, int timeEffect){
        super(name, stats);
        this.timeEffect = timeEffect;
    }

    public int getTimeEffect(){
        return this.timeEffect;
    }

    @Override
    protected void consume(Character character){
        ActionCommand consumeTemporaryItemCommand = new ConsumeTemporaryItemCommand(character, this);
        consumeTemporaryItemCommand.execute();
    }
}
