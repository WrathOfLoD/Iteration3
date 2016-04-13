package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;

/**
 * Created by luluding on 4/13/16.
 */
public class PickPocketAbility extends UntimedAbility{
    private SneakSkillManager ssm;

    public PickPocketAbility(Character character, int manaCost) {
        super(character, manaCost);
        ssm = (SneakSkillManager)getCharacter().getSkillManager();
    }

    public PickPocketAbility(int unlockLevel, Character character, int manaCost){
        super(unlockLevel, character, manaCost);
        ssm = (SneakSkillManager)getCharacter().getSkillManager();
    }


    @Override
    public boolean shouldDoAbility() {
        return checkCanCastAbility(ssm.getPickPocketLevel());
    }

    @Override
    public void doAbilityHook() {
        //TODO: write the do ability logic for pick poket here
    }
}
