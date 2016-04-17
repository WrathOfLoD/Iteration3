package com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.FireBallHitBoxFactory;
import com.wrathOfLoD.Models.RangedEffect.REG.LineREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;

/**
 * Created by zach on 4/7/16.
 */
public class FireballAbility extends BlastAbility {

    public FireballAbility(Character character, int windup, int coolDown, int totalDistance, int travelTime) {
        super(character, windup, coolDown, totalDistance, travelTime);
    }

    public FireballAbility(int unlockingLevel, Character character, int windup, int coolDown, int totalDistance, int traveTime){
        super(unlockingLevel, character, windup, coolDown, totalDistance, traveTime);
    }

    @Override
    public void windUpHook(){
        //TODO: CHECK WHETHER THERE IS TARGET. Char.getActiveTarget?

        RangedEffectGenerator reg = new LineREG(
                getTotalDistance(),
                getCharacter().getPosition(),
                calcualteDmg(),
                getTravelTime(),
                new FireBallHitBoxFactory(),
                getCharacter().getDirection());

        reg.doRangedEffect();
    }
}
