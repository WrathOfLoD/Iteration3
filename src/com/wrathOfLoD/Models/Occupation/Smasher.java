package com.wrathOfLoD.Models.Occupation;

import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.SmasherWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.SneakWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.SummonerWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SmasherSkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by zach on 4/7/16.
 */
public class Smasher extends Occupation {

    public Smasher() {
        StatsModifiable statsModifiable = StatsModifiable.createGenericStatsModifiable(5,1,1,1,0);
        setStatsModifiable(statsModifiable);
    }

    public void levelUp(Stats stats) {}

    @Override
    public  boolean canEquip(SmasherWeapon weapon){
        return true;
    }

    @Override
    public  boolean canEquip(SneakWeapon weapon){
        return false;
    }

    @Override
    public  boolean canEquip(SummonerWeapon weapon){
        return false;
    }

    @Override
    public SkillManager createSkillManager() {
        return new SmasherSkillManager();
    }

    @Override
    public Weapon createWeapon(){
        return new FistWeapon();
    }

    public void addAbilities(AbilityManager abilityManager){
        super.addAbilities(abilityManager);
        //TODO: ADD ABILITIES, CALL SUPER
    }
}
