package com.wrathOfLoD.Models.Occupation;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FanBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.FireballAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.PrismBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.RadialBombBlastAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites.BoonBoostDefenseAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites.BoonBoostSpeedAbility;
import com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites.BoonStrengthenAbility;
import com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites.EnchantmentMakeFriendlyAbility;
import com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites.EnchantmentMakeSlowAbility;
import com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites.EnchantmentMakeWeakAbility;
import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.SmasherWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.SneakWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.StaffWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.SummonerWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by zach on 4/7/16.
 */

public class Summoner extends Occupation {

    public Summoner() {
        StatsModifiable statsModifiable = StatsModifiable.createGenericStatsModifiable(1,1,5,1,0);
        setStatsModifiable(statsModifiable);
    }

    public void levelUp(Stats stats) {}

    @Override
    public  boolean canEquip(SmasherWeapon weapon){
        return false;
    }

    @Override
    public  boolean canEquip(SneakWeapon weapon){
        return false;
    }

    @Override
    public  boolean canEquip(SummonerWeapon weapon){
        return true;
    }

    @Override
    public SkillManager createSkillManager() {
        return new SummonerSkillManager();
    }

    @Override
    public String getName(){ return "Summoner"; }

    @Override
    public Weapon createWeapon(){
        return new StaffWeapon();
    }

    public void addAbilities(AbilityManager abilityManager, Character character){
        super.addAbilities(abilityManager, character);
        Ability fireBallAbility = new FireballAbility(character, 5, 10, 5, 10);
        Ability fanBlastAbility = new FanBlastAbility(3, character, 5, 10, 5, 10);
        Ability radialBombBlastAbility  = new RadialBombBlastAbility(5, character, 5, 10,5, 10);
        Ability boonStrengthenAbility = new BoonStrengthenAbility(character, 10, 100);
        Ability boonBoostSpeedAbility = new BoonBoostSpeedAbility(3, character, 10, 100);
        Ability boonBoostDefenseAbility = new BoonBoostDefenseAbility(5, character, 10, 100);
        Ability enchantmentMakeFriendlyAbility = new EnchantmentMakeFriendlyAbility(character, 10, 30);
        Ability enchantmentMakeWeakAbility = new EnchantmentMakeWeakAbility(3, character, 10, 30);
        Ability enchantmentMakeSlowAbility = new EnchantmentMakeSlowAbility(5, character, 10, 30);
        Ability prismBlastAbility = new PrismBlastAbility(character, 5, 10, 1, 15);

        abilityManager.addAbilities(fireBallAbility);
        abilityManager.addAbilities(fanBlastAbility);
        abilityManager.addAbilities(radialBombBlastAbility);
        abilityManager.addAbilities(boonStrengthenAbility);
        abilityManager.addAbilities(boonBoostSpeedAbility);
        abilityManager.addAbilities(boonBoostDefenseAbility);
        abilityManager.addAbilities(enchantmentMakeFriendlyAbility);
        abilityManager.addAbilities(enchantmentMakeWeakAbility);
        abilityManager.addAbilities(enchantmentMakeSlowAbility);
        abilityManager.addAbilities(prismBlastAbility);

        character.equipAbility2(fireBallAbility);
        character.equipAbility3(fanBlastAbility);
        character.equipAbility4(boonStrengthenAbility);
        character.equipAbility5(enchantmentMakeFriendlyAbility);
        //character.equipAbility6(enchantmentMakeWeakAbility);
        character.equipAbility6(prismBlastAbility);
    }
}