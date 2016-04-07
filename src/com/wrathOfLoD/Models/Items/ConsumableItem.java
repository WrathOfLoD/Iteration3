package com.wrathOfLoD.Models.Items;

import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class ConsumableItem extends Item{
    private StatsAddable stats;

    public ConsumableItem(Position position, String name, StatsAddable stats){
        super(position, name);
        this.stats = stats;
    }
}
