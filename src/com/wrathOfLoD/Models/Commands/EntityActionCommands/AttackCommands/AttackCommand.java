package com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Entity.Character.Character;

/**
 * Created by matthewdiaz on 4/13/16.
 */
public class AttackCommand extends ActionCommand {
    private Character character;
    private Weapon weapon;
    private int skillLevel;

    public AttackCommand(Character character, Weapon weapon, int skillLevel){
        this.character = character;
        this.weapon = weapon;
        this.skillLevel = skillLevel;
    }

    protected Character getCharacter(){
        return this.character;
    }

    protected Weapon getWeapon(){
        return this.weapon;
    }

    protected int getSkillLevel(){
        return this.skillLevel;
    }

    @Override
    public void execute() {

    }
}
