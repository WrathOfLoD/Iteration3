package com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/18/16.
 */

public class BoonBoostSpeedAbility  extends BoonAbility{
    private StatsModifiable speedBooster;

    public BoonBoostSpeedAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown);
        setName("Boon Boost Speed Ability");
    }

    public BoonBoostSpeedAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown);
        setName("Boon Boost Speed Ability");
    }

    @Override
    public void windUpHook() {
        int speedBoost = 20 * calculateAbilityLevelBoost();
        speedBooster = StatsModifiable.createMovementStatsModifiable(speedBoost);
        getCharacter().getStats().addTemporaryStats(speedBooster);
    }

    @Override
    public void coolDownHook(){
        getCharacter().getStats().removeTemporaryStats(speedBooster);
    }
}