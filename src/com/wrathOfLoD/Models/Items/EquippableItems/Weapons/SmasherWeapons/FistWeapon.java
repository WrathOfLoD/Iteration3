package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SmasherSkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

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

    @Override
    protected int getSkillHook(SkillManager skillManager) {
        SmasherSkillManager smasherSkillManager = (SmasherSkillManager)skillManager;
        return smasherSkillManager.getBrawlingLevel();
    }
}
