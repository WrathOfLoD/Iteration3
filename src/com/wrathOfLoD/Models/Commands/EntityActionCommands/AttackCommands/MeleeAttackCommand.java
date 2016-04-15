package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class MeleeAttackCommand extends AttackCommand {
    public MeleeAttackCommand(Character character, int coolDown, int windUp, int skillLevel) {
        super(character, coolDown, windUp, skillLevel);
    }
}
