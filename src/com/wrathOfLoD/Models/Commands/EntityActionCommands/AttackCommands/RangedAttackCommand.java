package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.FireBallHitBoxFactory;
import com.wrathOfLoD.Models.RangedEffect.REG.LineREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class RangedAttackCommand extends AttackCommand {
    private int totalDistance;
    private int travelTime;

    public RangedAttackCommand(Character character, int coolDown, int windUp, int skillLevel, int totalDistance, int travelTime) {
        super(character, coolDown, windUp, skillLevel);
        this.totalDistance = totalDistance;
        this.travelTime = travelTime;
    }

    protected int getTotalDistance(){
        return totalDistance;
    }

    private  int getTravelTime(){
        return travelTime;
    }

    @Override
    protected void windUpHook(Position characterPosition, Direction characterFacingDirection, int attackDamage) {
        RangedEffectGenerator reg = new LineREG(
                getTotalDistance(),
                getCharacter().getPosition(),
                attackDamage,
                getTravelTime(),
                new FireBallHitBoxFactory(),
                characterFacingDirection);

        reg.doRangedEffect();
    }
}
