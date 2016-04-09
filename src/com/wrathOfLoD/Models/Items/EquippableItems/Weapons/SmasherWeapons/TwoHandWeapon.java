package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class TwoHandWeapon extends Weapon implements SmasherWeapon{
    public TwoHandWeapon(String name, StatsModifiable stats, int attackSpeed, int baseDamage, int coolDown, int windUp) {
        super(name, stats, attackSpeed, baseDamage, coolDown, windUp);
    }

    public TwoHandWeapon(String name) { //edit; delete this it's only for testing purposes
        super(name);
    }

    @Override
    protected boolean occupationCheckHook(Occupation o) {
        return o.canEquip(this);
    }
}
