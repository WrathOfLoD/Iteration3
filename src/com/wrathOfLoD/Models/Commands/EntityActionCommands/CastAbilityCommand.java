package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.Ability.Abilities.Ability;
import com.wrathOfLoD.Models.Commands.ActionCommand;

/**
 * Created by luluding on 4/17/16.
 */
public class CastAbilityCommand extends ActionCommand {
    private Ability ability;

    public CastAbilityCommand(Ability ability){
        this.ability = ability;
    }

    @Override
    public void execute() {
        ability.doAbility();
    }
}
