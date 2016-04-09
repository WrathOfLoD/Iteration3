package com.wrathOfLoD.Models.Items.EquippableItems;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class EquippableItem extends TakeableItem {
    private StatsModifiable stats;

    public EquippableItem(String name, StatsModifiable stats){
        super(name);
        this.stats = stats;
    }

    public EquippableItem(Position position, String name, StatsModifiable stats){
        super(position, name);
        this.stats = stats;
    }

    public StatsModifiable getStats(){
        return stats;
    }

    protected abstract void equip(Character character);

    @Override
    public void use(Character character){
        this.equip(character);
    }
}
