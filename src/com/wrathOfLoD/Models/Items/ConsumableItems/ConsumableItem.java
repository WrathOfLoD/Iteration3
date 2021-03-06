package com.wrathOfLoD.Models.Items.ConsumableItems;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class ConsumableItem extends TakeableItem {
    private StatsModifiable statsModifiable;

    public ConsumableItem(String name, StatsModifiable statsModifiable){
        super(name);
        this.statsModifiable = statsModifiable;
    }

    public StatsModifiable getStatsModifiable(){
        return statsModifiable;
    }

    @Override
    public void use(Character character){
        this.consume(character);
    }

    protected abstract void consume(Character character);

    public void accept(ItemVisitor iv){
        iv.visitConsumableItem(this);
    }
}
