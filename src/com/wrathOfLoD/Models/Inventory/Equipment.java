package com.wrathOfLoD.Models.Inventory;

import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.Greaves;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Observers.EquipmentObserver;
import com.wrathOfLoD.Observers.Observable;
import com.wrathOfLoD.Observers.Observer;

import java.util.ArrayList;

/**
 * Created by zach on 4/7/16.
 */
public class Equipment{
    private final Weapon defaultWeapon = new DefaultWeapon();
    private Armor armor;
    private Weapon weapon;
    private Greaves greaves;
    private Helm helm;
    private ArrayList<EquipmentObserver> observers = new ArrayList<EquipmentObserver>();

    private class DefaultWeapon extends Weapon{
        public DefaultWeapon(){
            super();
        }

        @Override
        protected boolean occupationCheckHook(Occupation o){
            return true;
        }
    }

    public Equipment() {
        this.weapon = defaultWeapon;
        this.armor = null;
        this.greaves = null;
        this.helm = null;
    }

    /***** getter & setter for Equipment *******/
    public Weapon getDefaultWeapon() {
        return defaultWeapon;
    }
    public Armor getArmor() {
        return armor;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public Greaves getGreaves() {
        return greaves;
    }
    public Helm getHelm() {return helm;}

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setGreaves(Greaves greaves) {
        this.greaves = greaves;
    }
    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    /***** END of getter & setter *******/

    public void alertUpdate(){
        System.out.println("ATTEMPTING AN Equipment change from equipment");
        for (EquipmentObserver o: observers) {
            o.alertEquipmentChange();
        }
    }

    public void addObserver(EquipmentObserver observer) {
        observers.add(observer);
    }

    public void equip(Armor armor){
        unequip(this.armor);
        this.armor = armor;
        alertUpdate();
    }

    public void equip(Greaves greaves) {
        unequip(this.greaves);
        this.greaves = greaves;
        alertUpdate();
    }

    public void equip(Helm helm){
        unequip(this.helm);
        this.helm = helm;
        alertUpdate();
    }

    public void equip(Weapon weapon) {
        if(this.weapon != defaultWeapon){
            unequip(this.weapon);
        }

        this.weapon = weapon;
        alertUpdate();
    }

    public boolean unequip(Armor armor){
        if(this.armor == armor){
            this.armor = null;
            alertUpdate();
            return true;
        }
        return false;
    }

    public boolean unequip(Greaves greaves){
        if(this.greaves == greaves){
            this.armor = null;
            alertUpdate();
            return true;
        }
        return false;
    }

    public boolean unequip(Helm helm){
        if(this.helm == helm){
            this.armor = null;
            alertUpdate();
            return true;
        }
        return false;
    }

    public boolean unequip(Weapon weapon) {
        if(this.weapon == weapon){
            equip(defaultWeapon);
            alertUpdate();
            return true;
        }
        return false;
    }
}
