package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class RangedWeapon extends Weapon implements SneakWeapon {
    public RangedWeapon(String name, StatsModifiable stats, int coolDown, int windUp) {
        super(name, stats, coolDown, windUp);
    }
    @Override
    protected boolean occupationCheckHook(Occupation o) {
        return o.canEquip(this);
    }
}

