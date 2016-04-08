package com.wrathOfLoD.Models.Items.EquippableItems;

import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class Armor extends EquippableItem{
    private int armorBonus;

    public Armor(Position position, String name, StatsModifiable stats, int armorBonus){
        super(position, name, stats);
        this.armorBonus = armorBonus;
    }

    public int getArmorBonus(){
        return this.armorBonus;
    }

    public void equip(Character character){
        character.equipArmor(this);
    }
}
