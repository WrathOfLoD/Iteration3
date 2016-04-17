package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Skill.SneakSkillManager;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/17/16.
 */
public class RemoveTrapAbility extends Ability {
    private SneakSkillManager ssm;

    public RemoveTrapAbility(Character character, int manaCost) {
        super(character, manaCost);
        ssm = (SneakSkillManager) character.getSkillManager();
    }

    public boolean shouldDoAbility(){
        return checkCanCastAbility(ssm.getRemoveTrapLevel());
    }

    public void doAbilityHook(){
        Character character = getCharacter();
        Position position = character.getPosition().getPosInDir(character.getDirection());

        Map.getInstance().removeTrap(position);
    }
}

