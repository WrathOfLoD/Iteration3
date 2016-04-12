package com.wrathOfLoD.Models.Items.ConsumableItems;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class PermanentConsumable extends ConsumableItem {
    public PermanentConsumable(String name, StatsModifiable stats){
        super(name, stats);
    }

    @Override
    protected void consume(Character character){
        character.consume(this);
    }
}
