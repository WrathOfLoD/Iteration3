package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class OneHandWeapon extends Weapon implements SmasherWeapon{
    public OneHandWeapon(Position position, String name, StatsModifiable stats, int attackSpeed, int baseDamage, int coolDown, int windUp) {
        super(position, name, stats, attackSpeed, baseDamage, coolDown, windUp);
    }
}
