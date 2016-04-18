package com.wrathOfLoD.Models.Ability.Abilities.BoonAbilites;

import com.wrathOfLoD.GameClock.TimeModel;
import com.wrathOfLoD.Models.Ability.Abilities.TimedAbility;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Utility.ModelConfig;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public abstract class BoonAbility extends TimedAbility {
    private SummonerSkillManager ssm;


    public BoonAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown, ModelConfig.getMidManaCost());
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    public BoonAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown, ModelConfig.getMidManaCost());
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
    }

    @Override
    public boolean shouldDoAbility() {
        return checkCanCastAbility(ssm.getBoonLevel());
    }

    protected int calculateAbilityLevelBoost(){
        return 2 * ssm.getBoonLevel();
    }

    protected abstract void coolDownHook();

    @Override
    public void tick(){
        int tick = getCurrentTick();
        tick++;
        if(tick == getWindup()){
            windUpHook();
        }else if(tick == getCoolDown()){
            coolDownHook();
            TimeModel.getInstance().deregisterTickable(this);
            getCharacter().setInactive();
        }
    }
}
