package com.wrathOfLoD.Models.Commands.EntityActionCommands.ConsumeItemCommands;

import com.wrathOfLoD.GameClock.Fuseable;
import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.ConsumableItems.ConsumableItem;
import com.wrathOfLoD.Models.Items.ConsumableItems.TemporaryConsumable;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/12/16.
 */
public class ConsumeTemporaryItemCommand extends ConsumeItemCommand implements Fuseable{
    public ConsumeTemporaryItemCommand(Entity entity, TemporaryConsumable temporaryConsumable){
        super(entity, temporaryConsumable);
    }

    @Override
    protected void hook(Stats entityStats, ConsumableItem item){
        TemporaryConsumable temporaryConsumable = (TemporaryConsumable)item;
        entityStats.addTemporaryStats(temporaryConsumable.getStatsModifiable());
        int timeEffect = temporaryConsumable.getTimeEffect();
        TimeModel.getInstance().registerFuseable(this, timeEffect);
    }

    @Override
    public void explode() {
        Entity entity = getEntity();
        Stats entityStats = entity.getStats();
        StatsModifiable statsModifiable = getItem().getStatsModifiable();
        //take away the stats
        entityStats.removeTemporaryStats(statsModifiable);
    }
}
