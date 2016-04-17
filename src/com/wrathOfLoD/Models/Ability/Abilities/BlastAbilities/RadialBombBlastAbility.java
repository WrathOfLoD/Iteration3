package com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.FireBallHitBoxFactory;
import com.wrathOfLoD.Models.RangedEffect.REG.CircularREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;

/**
 * Created by matthewdiaz on 4/17/16.
 */
public class RadialBombBlastAbility extends BlastAbility {
    public RadialBombBlastAbility(Character character, int windup, int coolDown, int totalDistance, int travelTime) {
        super(character, windup, coolDown, totalDistance, travelTime);
    }

    public RadialBombBlastAbility(int unlockingLevel, Character character, int windup, int coolDown, int totalDistance, int travelTime){
        super(unlockingLevel, character, windup, coolDown, totalDistance, travelTime);
    }

    @Override
    public void windUpHook(){
        //TODO: CHECK WHETHER THERE IS TARGET. Char.getActiveTarget?
        RangedEffectGenerator reg = new CircularREG(
                getTotalDistance(),
                getCharacter().getPosition(),
                calcualteDmg(),
                getTravelTime(),
                new FireBallHitBoxFactory());

        reg.doRangedEffect();
    }
}