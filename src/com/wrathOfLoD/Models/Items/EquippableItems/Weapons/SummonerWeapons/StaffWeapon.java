package com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons;

import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SmasherSkillManager;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public class StaffWeapon extends Weapon implements SummonerWeapon {
    public StaffWeapon(){
        super();
    }

    public StaffWeapon( String name, StatsModifiable stats, int coolDown, int windUp) {
        super( name, stats, coolDown, windUp);
    }

    @Override
    protected boolean occupationCheckHook(Occupation o) {
        return o.canEquip(this);
    }

    @Override
    protected int getSkillHook(SkillManager skillManager) {
        SummonerSkillManager smasherSkillManager = (SummonerSkillManager)skillManager;
        return smasherSkillManager.getStaffLevel();
    }
}
