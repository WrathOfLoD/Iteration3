package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class FistWeapon extends Weapon implements SmasherWeapon {
    public FistWeapon( String name, StatsModifiable stats, int coolDown, int windUp) {
        super(name, stats, coolDown, windUp);
    }

    @Override
    protected boolean occupationCheckHook(Occupation o) {
        return o.canEquip(this);
    }
}
