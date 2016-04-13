package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class BackStabWeapon extends Weapon implements SneakWeapon {
    public BackStabWeapon(String name, StatsModifiable stats, int coolDown, int windUp) {
        super(name, stats, coolDown, windUp);
    }

    @Override
    protected boolean occupationCheckHook(Occupation o) {
        return o.canEquip(this);
    }

    @Override
    protected int getSkillHook(SkillManager skillManager) {
        SneakSkillManager smasherSkillManager = (SneakSkillManager)skillManager;
        return smasherSkillManager.getCreepLevel();
    }
}

