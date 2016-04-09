package com.wrathOfLoD.Models.Inventory;

import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Utility.Position;

/**
 * Created by zach on 4/7/16.
 */
public class Equipment {
    private class DefaultWeapon extends Weapon{
        public DefaultWeapon(){
            super();
        }

        @Override
        protected  boolean occupationCheckHook(Occupation o){
            return true;
        }
    }

    private final Weapon defaultWeapon = new DefaultWeapon();
    private Armor armor;
    private Weapon weapon;

    public Equipment() {
        this.equip(defaultWeapon);
    }

    public void equip(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equip(Armor armor){
        this.armor = armor;
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
