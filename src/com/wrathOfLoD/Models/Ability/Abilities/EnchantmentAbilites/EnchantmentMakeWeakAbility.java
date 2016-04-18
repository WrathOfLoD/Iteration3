package com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public class EnchantmentMakeWeakAbility extends EnchantmentAbility{
    public EnchantmentMakeWeakAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown);
        setName("Enchanment Make Weak Ability");
    }

    public EnchantmentMakeWeakAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown);
        setName("Enchanment Make Weak Ability");

    }

    @Override
    protected void doEnchantment(Entity foe){
        int weakBoost = 10 * calculateAbilityLevelBoost();
        StatsModifiable weakenStatsModifiable = StatsModifiable.createStrengthStatsModifiable(-weakBoost);
        foe.getStats().modifyStats(weakenStatsModifiable);
    }
}