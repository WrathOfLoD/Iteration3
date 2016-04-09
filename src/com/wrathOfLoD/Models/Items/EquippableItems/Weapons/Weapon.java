package com.wrathOfLoD.Models.Items.EquippableItems.Weapons;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by matthewdiaz on 4/7/16.
 */
public abstract class Weapon extends EquippableItem{
    private int attackSpeed;
    private int baseDamage;
    private int coolDown;
    private int windUp;

    public Weapon(){
        this("space weapon", StatsModifiable.createWeaponBonusStatsModifiable(10), 1, 1, 1, 1);
    }

    public Weapon( String name, StatsModifiable stats, int attackSpeed, int baseDamage, int coolDown, int windUp){
        super(name,stats);
        this.attackSpeed = attackSpeed;
        this.baseDamage = baseDamage;
        this.coolDown = coolDown;
        this.windUp = windUp;
    }

    public Weapon(String name){ //edit: delete this it's only for testing purposes
        super(name);
    }

    /***** getter & setter for Weapon *******/

    public int getAttackSpeed(){ return this.attackSpeed; }

    public int getBaseDamage(){ return this.baseDamage; }

    public int getCoolDown(){ return this.coolDown; }

    public int getWindUp(){ return this.windUp; }

    /********* END Getters and Setters *********/

    protected abstract boolean occupationCheckHook(Occupation o);

    public void equip(Character character){
        Occupation occupation = character.getOccupation();
        if(occupationCheckHook(occupation) ){
            character.equip(this);
        }
    }
}
