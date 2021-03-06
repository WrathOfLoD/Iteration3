package com.wrathOfLoD.Models.Occupation;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Ability.Abilities.DetectTrapAbility;
import com.wrathOfLoD.Models.Ability.Abilities.PickPocketAbility;
import com.wrathOfLoD.Models.Ability.Abilities.RemoveTrapAbility;
import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.SmasherWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.BackStabWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.RangedWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.SneakWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.SummonerWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by zach on 4/7/16.
 */

public class Sneak extends Occupation {

    public Sneak() {
        StatsModifiable statsModifiable = StatsModifiable.createGenericStatsModifiable(1,5,1,1,0);
        setStatsModifiable(statsModifiable);
    }

    public void levelUp(Stats stats) {}

    @Override
    public  boolean canEquip(SmasherWeapon weapon){
        return false;
    }

    @Override
    public  boolean canEquip(SneakWeapon weapon){
        return true;
    }

    @Override
    public  boolean canEquip(SummonerWeapon weapon){
        return false;
    }

    @Override
    public SkillManager createSkillManager() {
        return new SneakSkillManager();
    }

    @Override
    public String getName(){ return "Sneak"; }

    @Override
    public Weapon createWeapon(){
        return new RangedWeapon("Blaster", StatsModifiable.createWeaponBonusStatsModifiable(10), 20, 10);
    }

    public void addAbilities(AbilityManager abilityManager, Character character){
        super.addAbilities(abilityManager, character);
        Ability pickPocketAbility = new PickPocketAbility(character, 10);
        Ability detectTrapAbility = new DetectTrapAbility(character, 10);
        Ability removeTrapAbility = new RemoveTrapAbility(character, 10);

        abilityManager.addAbilities(pickPocketAbility);
        abilityManager.addAbilities(detectTrapAbility);
        abilityManager.addAbilities(removeTrapAbility);

        character.equipAbility2(pickPocketAbility);
        character.equipAbility3(detectTrapAbility);
        character.equipAbility4(removeTrapAbility);
    }
}