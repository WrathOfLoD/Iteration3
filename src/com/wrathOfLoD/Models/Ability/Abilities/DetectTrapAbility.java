package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;

/**
 * Created by matthewdiaz on 4/17/16.
 */
public class DetectTrapAbility extends Ability {
    private SneakSkillManager ssm;

    public DetectTrapAbility(Character character, int manaCost) {
        super(character, manaCost);
        ssm = (SneakSkillManager) character.getSkillManager();
    }

    public boolean shouldDoAbility(){
        return checkCanCastAbility(ssm.getDetectTrapLevel());
    }

    public void doAbilityHook(){
        //TODO: Acquire entity range
        //TODO: call trap.detect!!
    }
}
