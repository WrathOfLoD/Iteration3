package com.wrathOfLoD.Models.Items.ConsumableItems;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class TemporaryConsumable extends ConsumableItem {
    public TemporaryConsumable(String name, StatsModifiable stats){
        super(name, stats);
    }

    @Override
    protected void consume(Character character){
        character.consume(this);
    }
}
