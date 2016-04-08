package com.wrathOfLoD.Models.Items.EquippableItems.Weapons;

import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
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

    public Weapon(Position position, String name, StatsModifiable stats, int attackSpeed, int baseDamage, int coolDown, int windUp){
        super(position,name,stats);
        this.attackSpeed = attackSpeed;
        this.baseDamage = baseDamage;
        this.coolDown = coolDown;
        this.windUp = windUp;
    }

    /*get methods */
    public int getAttackSpeed(){ return this.attackSpeed; }

    public int getBaseDamage(){
        return this.baseDamage;
    }

    public int getCoolDown(){
        return this.coolDown;
    }

    public int getWindUp(){
        return this.windUp;
    }

    public void equip(Character character){
        character.equipWeapon(this);
    }
}
