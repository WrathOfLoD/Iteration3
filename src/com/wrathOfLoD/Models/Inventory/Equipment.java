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
public class Equipment {

    private ArrayList<EquipmentObserver> observers = new ArrayList<EquipmentObserver>();

    public void alertUpdate(){
        System.out.println("ATTEMPTING AN Equipment change from equipment");

        for (EquipmentObserver o: observers) {
            o.alertEquipmentChange(this);
        }
    }

    public void addObserver(EquipmentObserver observer) {
        observers.add(observer);
    }

    private final Weapon defaultWeapon = new DefaultWeapon();
    private Armor armor;
    private Weapon weapon;
    private Greaves greaves;
    private Helm helm;


    public Weapon getDefaultWeapon() {
        return defaultWeapon;
    }
    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Greaves getGreaves() {
        return greaves;
    }
    public void setGreaves(Greaves greaves) {
        this.greaves = greaves;
    }
    public Helm getHelm() {
        return helm;
    }
    public void setHelm(Helm helm) {
        this.helm = helm;
    }

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
        alertUpdate();
    }

    public void equip(Greaves greaves) {
        this.greaves = greaves;
    }

    public void equip(Helm helm){
//        unequip(this.getHelm()); // TODO: 4/12/2016 is this needed?
        this.helm = helm;
        alertUpdate();
    }

    public void equip(Weapon weapon) {
        this.weapon = weapon;
        alertUpdate();
        // TODO: 4/9/16 do the below for the view
        // alertWeaponEquipped(weapon);
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
