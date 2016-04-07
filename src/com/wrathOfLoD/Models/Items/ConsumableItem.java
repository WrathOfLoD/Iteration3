package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class ConsumableItem extends Item{
    private StatsModifiable stats;

    public ConsumableItem(Position position, String name, StatsModifiable stats){
        super(position, name);
        this.stats = stats;
    }
}
