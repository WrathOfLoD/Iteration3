package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by matthewdiaz on 4/18/16.
 */
public class PerformAttackCommand extends ActionCommand {
    private Character character;

    public PerformAttackCommand(Character character){
        this.character = character;
    }

    @Override
    public void execute() {
        character.attack();
    }

}
