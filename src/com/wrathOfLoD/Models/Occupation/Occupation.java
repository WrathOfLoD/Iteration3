package com.wrathOfLoD.Models.Occupation;

import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Ability.Abilities.BindWoundsAbility;
import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.SmasherWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.SneakWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.SummonerWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Skill.Skill;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by zach on 4/7/16.
 */
public abstract class Occupation {
    private StatsModifiable statsModifiable;

    public StatsModifiable getStatsModifiable(){return this.statsModifiable; }

    public abstract boolean canEquip(SmasherWeapon weapon);

    public abstract boolean canEquip(SneakWeapon weapon);

    public abstract boolean canEquip(SummonerWeapon weapon);

    public abstract SkillManager createSkillManager();

    public abstract Weapon createWeapon();

    public void levelUp(Stats stats) {

    }

    protected void setStatsModifiable(StatsModifiable newStatsModifiable){
        this.statsModifiable = newStatsModifiable;
    }

    public void addAbilities(AbilityManager abilityManager){
        Character character = abilityManager.getCharacter();
        //TODO: ADD ABILITIES
        abilityManager.addAbilities(new BindWoundsAbility(character, 10, 5) );
    }
}
