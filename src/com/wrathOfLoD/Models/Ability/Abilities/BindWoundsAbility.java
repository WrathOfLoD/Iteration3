package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Skill.SummonerSkillManager;
import com.wrathOfLoD.Utility.Direction;
import com.wrathOfLoD.Utility.ModelConfig;

/**
 * Created by zach on 4/7/16.
 */
public class BindWoundsAbility extends TimedAbility{
    private SummonerSkillManager ssm;


    public BindWoundsAbility(Character character, int windup, int coolDown) {
        super(character, windup, coolDown, ModelConfig.getMidManaCost());
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
        setName("Bind Wounds");
    }

    public BindWoundsAbility(int unlockingLevel, Character character, int windup,int coolDown){
        super(unlockingLevel, character, windup, coolDown, ModelConfig.getMidManaCost());
        ssm = (SummonerSkillManager) getCharacter().getSkillManager();
        setName("Bind Wounds");
    }


    @Override
    public void windUpHook() {
        getCharacter().heal(calculateHealAmount());
    }

    @Override
    public boolean shouldDoAbility() {
        return true;
    }

    private int calculateHealAmount(){
        //TODO: Balance later
        return 2 * ssm.getBindWoundsLevel();
    }
}
