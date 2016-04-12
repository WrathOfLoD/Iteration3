package com.wrathOfLoD.Models.Items.EquippableItems;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class EquippableItem extends TakeableItem {
    private StatsModifiable statsModifiable;

    public EquippableItem(String name, StatsModifiable statsModifiable){
        super(name);
        this.statsModifiable = statsModifiable;
    }

    public EquippableItem(String name){ //edit: delete this it's only being used for testing purposes
        super(name);
        this.statsModifiable = StatsModifiable.createWeaponArmorStatsModifiable(10,10);
    }

    public StatsModifiable getStatsModifiable(){
        return statsModifiable;
    }

    protected abstract void equip(Character character);

    public abstract void unequip(Character character);

    @Override
    public void use(Character character){
        this.equip(character);
    }
}
