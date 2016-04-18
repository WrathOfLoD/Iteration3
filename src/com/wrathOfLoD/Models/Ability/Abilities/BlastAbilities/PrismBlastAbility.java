package com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.FireBallHitBoxFactory;
import com.wrathOfLoD.Models.RangedEffect.REG.CircularREG;
import com.wrathOfLoD.Models.RangedEffect.REG.FanREG;
import com.wrathOfLoD.Models.RangedEffect.REG.PrismREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;

/**
 * Created by luluding on 4/18/16.
 */
public class PrismBlastAbility extends BlastAbility {
    public PrismBlastAbility(Character character, int windup, int coolDown, int totalDistance, int travelTime) {
        super(character, windup, coolDown, totalDistance, travelTime);
    }

    public PrismBlastAbility(int unlockingLevel, Character character, int windup, int coolDown, int totalDistance, int travelTime){
        super(unlockingLevel, character, windup, coolDown, totalDistance, travelTime);
    }


    @Override
    public void windUpHook() {
        RangedEffectGenerator reg = new PrismREG(
                getTotalDistance(),
                getCharacter().getPosition(),
                calcualteDmg(),
                getTravelTime(),
                new FireBallHitBoxFactory(),
                getCharacter().getDirection());

        reg.doRangedEffect();
    }
}
