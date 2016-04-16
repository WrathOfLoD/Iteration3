package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.RangedEffect.HitBox.HitBoxFactories.FireBallHitBoxFactory;
import com.wrathOfLoD.Models.RangedEffect.REG.LineREG;
import com.wrathOfLoD.Models.RangedEffect.REG.RangedEffectGenerator;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.ModelConfig;

/**
 * Created by zach on 4/7/16.
 */
public class FireballAbility extends TimedAbility {
    private Direction direction;
    private int totalDistance;
    private int travelTime;
    private SummonerSkillManager ssm;

    public FireballAbility(Character character, int windup, int coolDown, Direction dir, int totalDistance, int travelTime) {
        super(character, windup, coolDown, ModelConfig.getMidManaCost());
        this.direction = dir;
        this.totalDistance = totalDistance;
        this.travelTime = travelTime;
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    public FireballAbility(int unlockingLevel, Character character, int windup,int coolDown, Direction dir, int totalDistance){
        super(unlockingLevel, character, windup, coolDown, ModelConfig.getMidManaCost());
        this.direction = dir;
        this.totalDistance = totalDistance;
        this.travelTime = travelTime;
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }


    @Override
    public void windUpHook(){
        //TODO: CHECK WHETHER THERE IS TARGET. Char.getActiveTarget?

        RangedEffectGenerator reg = new LineREG(
                totalDistance,
                getCharacter().getPosition(),
                calcualteDmg(),
                travelTime,
                new FireBallHitBoxFactory(),
                getCharacter().getDirection());

        reg.doRangedEffect();
    }

    @Override
    public boolean shouldDoAbility() {
        return checkCanCastAbility(ssm.getBaneLevel());
    }

    private int calcualteDmg(){
        //TODO: need to balance formula
        return getCharacter().getStats().getOffensiveRating() + (2 * ssm.getBaneLevel());
    }


}
