package com.wrathOfLoD.Models.Items.ConsumableItems;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class ConsumableItem extends TakeableItem {
    private StatsModifiable stats;

    public ConsumableItem(Position position, String name, StatsModifiable stats){
        super(position, name);
        this.stats = stats;
    }

    @Override
    public void use(Character character){
        this.consume(character);
    }

    protected void consume(Character character){

    }
}
