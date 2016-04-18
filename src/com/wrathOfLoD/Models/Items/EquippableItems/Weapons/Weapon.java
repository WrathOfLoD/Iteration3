package com.wrathOfLoD.Models.Items.EquippableItems.Weapons;

import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.AttackCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.AttackCommands.MeleeAttackCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipItemCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.EquipItemCommands.EquipWeaponCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipItemCommand;
import com.wrathOfLoD.Models.Commands.EntityActionCommands.UnequipItemCommands.UnequipWeaponCommand;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Stats.StatsModifiable;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Weapon extends EquippableItem{
    private int coolDown;
    private int windUp;

    public Weapon(){
        this("default weapon", StatsModifiable.createWeaponBonusStatsModifiable(1), 20, 10);
    }

    public Weapon( String name, StatsModifiable statsModifiable, int coolDown, int windUp){
        super(name,statsModifiable);
        this.coolDown = coolDown;
        this.windUp = windUp;
    }

    public Weapon(String name){ //edit: delete this it's only for testing purposes
        super(name);
    }

    /***** getter & setter for Weapon *******/

    public int getCoolDown(){ return this.coolDown; }

    public int getWindUp(){ return this.windUp; }

    /********* END Getters and Setters *********/

    protected abstract boolean occupationCheckHook(Occupation o);

    protected abstract int getSkillHook(SkillManager skillManager);

    @Override
    public void equip(Character character){
        Occupation occupation = character.getOccupation();
        if(occupationCheckHook(occupation) ){
            EquipItemCommand equipWeaponCommand = new EquipWeaponCommand(character, this);
            System.out.println("EQUIP WEAPN COMMAND");
            equipWeaponCommand.execute();
        }
    }

    @Override
    public void unequip(Character character){
        UnequipItemCommand unequipWeaponCommand = new UnequipWeaponCommand(character, this);
        unequipWeaponCommand.execute();
    }

    public void attack(Character character, SkillManager skillManager){
        int weaponSkillLevel = getSkillHook(skillManager);
        AttackCommand meleeAttackCommand = new MeleeAttackCommand(character, this.coolDown, this.windUp, weaponSkillLevel);
        meleeAttackCommand.execute();
    }

}
