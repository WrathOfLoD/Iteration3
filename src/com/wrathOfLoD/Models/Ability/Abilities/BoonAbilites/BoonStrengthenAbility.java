package com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public class BoonStrengthenAbility extends BoonAbility{
    private StatsModifiable strengthBooster;

    public BoonStrengthenAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown);
        setName("Boon Strengthen Ability");
    }

    public BoonStrengthenAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown);
        setName("Boon Strengthen Ability");
    }

    @Override
    public void windUpHook() {
        int strengthBoost = 10 * calculateAbilityLevelBoost();
        strengthBooster = StatsModifiable.createWeaponBonusStatsModifiable(strengthBoost);
        getCharacter().getStats().addTemporaryStats(strengthBooster);
    }

    @Override
    public void coolDownHook(){
        getCharacter().getStats().removeTemporaryStats(strengthBooster);
    }
}
