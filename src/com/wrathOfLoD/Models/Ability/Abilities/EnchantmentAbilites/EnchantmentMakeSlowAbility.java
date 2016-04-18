package com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Stats.StatsModifiable;


/**
 * Created by matthewdiaz on 4/18/16.
 */
public class EnchantmentMakeSlowAbility extends EnchantmentAbility{
    public EnchantmentMakeSlowAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown);
        setName("Enchantment Make Slow Ability");
    }

    public EnchantmentMakeSlowAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown);
        setName("Enchantment Make Slow Ability");
    }

    @Override
    protected void doEnchantment(Entity foe){
        int slowBoost = 10 * calculateAbilityLevelBoost();
        StatsModifiable slowStatsModifiable = StatsModifiable.createMovementStatsModifiable(-slowBoost);
        foe.getStats().modifyStats(slowStatsModifiable);
    }
}
