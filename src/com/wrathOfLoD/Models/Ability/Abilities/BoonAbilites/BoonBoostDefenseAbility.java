package com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public class BoonBoostDefenseAbility extends BoonAbility{
    private StatsModifiable defenseBooster;

    public BoonBoostDefenseAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown);
        setName("Boon Boost Defense Ability");
    }

    public BoonBoostDefenseAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown);
        setName("Boon Boost Defense Ability");
    }

    @Override
    public void windUpHook() {
        int speedBoost = 20 * calculateAbilityLevelBoost();
        defenseBooster = StatsModifiable.createMovementStatsModifiable(speedBoost);
        getCharacter().getStats().addTemporaryStats(defenseBooster);
    }

    @Override
    public void coolDownHook(){
        getCharacter().getStats().removeTemporaryStats(defenseBooster);
    }

}
