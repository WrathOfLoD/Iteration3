package com.wrathOfLoD.Models.Ability.Abilities.EnchantmentAbilites;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public class EnchantmentMakeFriendlyAbility extends EnchantmentAbility{
    public EnchantmentMakeFriendlyAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown);
        setName("Enchantment Make Friendly Ability");
    }

    public EnchantmentMakeFriendlyAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown);
        setName("Enchantment Make Friendly Ability");
    }

    @Override
    protected void doEnchantment(Entity foe){
        int friendlyBoost = 2 * calculateAbilityLevelBoost();
        foe.setAggroLevel(friendlyBoost);
    }
}