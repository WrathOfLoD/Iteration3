package com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities;

import com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities.BlastAbility;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.FireBallHitBoxFactory;
import com.wrathOfLoD.Models.RangedEffect.REG.FanREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;


/**
 * Created by matthewdiaz on 4/17/16.
 */

public class FanBlastAbility extends BlastAbility {

    public FanBlastAbility(Character character, int windup, int coolDown, int totalDistance, int travelTime) {
        super(character, windup, coolDown, totalDistance, travelTime);
    }

    public FanBlastAbility(int unlockingLevel, Character character, int windup, int coolDown, int totalDistance, int travelTime){
        super(unlockingLevel, character, windup, coolDown, totalDistance, travelTime);
    }

    @Override
    public void windUpHook(){

        RangedEffectGenerator reg = new FanREG(
                getTotalDistance(),
                getCharacter().getPosition(),
                calcualteDmg(),
                getTravelTime(),
                new FireBallHitBoxFactory(),
                getCharacter().getDirection());

        reg.doRangedEffect();
    }
}