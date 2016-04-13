package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class AttackCommand extends ActionCommand {
    private Character character;
    private Weapon weapon;

    public AttackCommand(Character character, Weapon weapon){
        this.character = character;
        this.weapon = weapon;
    }

    protected Character getCharacter(){
        return this.character;
    }

    protected Weapon getWeapon(){
        return this.weapon;
    }

    @Override
    public void execute() {

    }
}
