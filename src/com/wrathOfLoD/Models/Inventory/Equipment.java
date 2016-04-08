package com.wrathOfLoD.Models.Inventory;

import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;

/**
 * Created by zach on 4/7/16.
 */
public class Equipment {
    //private final Weapon defaultWeapon;
    private Armor armor;
    private Weapon weapon;

    public Equipment() {

    }

    public void equip(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equip(Armor armor){
        this.armor = armor;
    }

    public void unequip() {

    }

}
