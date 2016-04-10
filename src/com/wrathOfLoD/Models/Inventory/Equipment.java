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

    public void equip(Weapon weapon) {
        this.weapon = weapon;

        // TODO: 4/9/16 do the below for the view
        // alertWeaponEquipped(weapon);
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

    public void unequip(Weapon weapon) {
        if(weapon == this.weapon){
            equip(defaultWeapon);
        }
    }

    public void unequip(Armor armor){
        if(armor == this.armor){
            this.armor = null;
        }
    }
}
