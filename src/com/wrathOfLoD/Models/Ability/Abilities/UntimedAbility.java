package com.wrathOfLoD.Models.Ability.Abilities;

import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by luluding on 4/13/16.
 */

//doesn't use wind up and cool down
public abstract class UntimedAbility extends Ability {

    public UntimedAbility(Character character, int manaCost) {
        super(character, manaCost);
    }

    public UntimedAbility(int unlockLevel, Character character, int manaCost){
        super(unlockLevel, character, manaCost);
    }


}
