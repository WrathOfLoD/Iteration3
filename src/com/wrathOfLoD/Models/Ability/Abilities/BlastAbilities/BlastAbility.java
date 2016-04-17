package com.wrathOfLoD.Models.Ability.Abilities.BlastAbilities;

import com.wrathOfLoD.Models.Ability.Abilities.TimedAbility;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Utility.ModelConfig;

/**
 * Created by matthewdiaz on 4/17/16.
 */
public abstract class BlastAbility extends TimedAbility {
    private int totalDistance;
    private int travelTime;
    private SummonerSkillManager ssm;

    public BlastAbility(Character character, int windup, int coolDown, int totalDistance, int travelTime) {
        super(character, windup, coolDown, ModelConfig.getMidManaCost());
        this.totalDistance = totalDistance;
        this.travelTime = travelTime;
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    public BlastAbility(int unlockingLevel, Character character, int windup,int coolDown, int totalDistance, int travelTime){
        super(unlockingLevel, character, windup, coolDown, ModelConfig.getMidManaCost());
        this.totalDistance = totalDistance;
        this.travelTime  = travelTime;
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    public int getTotalDistance(){
        return this.totalDistance;
    }

    public int getTravelTime(){
        return this.travelTime;
    }

    @Override
    public boolean shouldDoAbility() {
        return checkCanCastAbility(ssm.getBaneLevel());
    }

    protected int calcualteDmg(){
        //TODO: need to balance formula
        return getCharacter().getStats().getOffensiveRating() + (2 * ssm.getBaneLevel());
    }


}

