package com.wrathOfLoD.Models.Inventory;

import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.Greaves;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;

/**
 * Created by zach on 4/7/16.
 */
public class Equipment {
    private final Weapon defaultWeapon = new DefaultWeapon();
    private Armor armor;
    private Weapon weapon;
    private Greaves greaves;
    private Helm helm;

    private class DefaultWeapon extends Weapon{
        public DefaultWeapon(){
            super();
        }

        @Override
        protected  boolean occupationCheckHook(Occupation o){
            return true;
        }
    }

    public Equipment() {
        this.equip(defaultWeapon);
        this.armor = null;
        this.greaves = null;
        this.helm = null;
    }

    public void equip(Armor armor){
        this.armor = armor;
    }

    public void equip(Greaves greaves) {
        this.greaves = greaves;
    }

    public void equip(Helm helm){
        this.helm = helm;
    }

    public void equip(Weapon weapon) {
        this.weapon = weapon;
    }

    public void unequip(Armor armor){
        if(this.armor == armor){
            this.armor = null;
        }
    }

    public void unequip(Greaves greaves){
        if(this.greaves == greaves){
            this.armor = null;
        }
    }

    public void unequip(Helm helm){
        if(this.helm == helm){
            this.armor = null;
        }
    }

    public void unequip(Weapon weapon) {
        if(this.weapon == weapon){
            equip(defaultWeapon);
        }
    }
}
