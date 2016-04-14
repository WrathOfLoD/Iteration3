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
public class Equipment implements Observable{
    private final Weapon defaultWeapon = new DefaultWeapon();
    private Armor armor;
    private Weapon weapon;
    private Greaves greaves;
    private Helm helm;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private class DefaultWeapon extends Weapon{
        public DefaultWeapon(){
            super();
        }

        @Override
        protected  boolean occupationCheckHook(Occupation o){
            return true;
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        System.out.println("ATTEMPTING AN Equipment change from equipment");
        for (Observer o: observers) {
            o.update();
        }
    }

    public Equipment() {
        this.equip(defaultWeapon);
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

    public void equip(Armor armor){
        this.armor = armor;
        notifyObservers();
    }

    public void equip(Greaves greaves) {
        this.greaves = greaves;
    }

    public void equip(Helm helm){
//        unequip(this.getHelm()); // TODO: 4/12/2016 is this needed?
        this.helm = helm;
        notifyObservers();
    }

    public void equip(Weapon weapon) {
        this.weapon = weapon;
        notifyObservers();
        // TODO: 4/9/16 do the below for the view
        // alertWeaponEquipped(weapon);
    }

    public boolean unequip(Armor armor){
        if(this.armor == armor){
            this.armor = null;
            notifyObservers();
            return true;
        }
        return false;
    }

    public boolean unequip(Greaves greaves){
        if(this.greaves == greaves){
            this.armor = null;
            notifyObservers();
            return true;
        }
        return false;
    }

    public boolean unequip(Helm helm){
        if(this.helm == helm){
            this.armor = null;
            notifyObservers();
            return true;
        }
        return false;
    }

    public boolean unequip(Weapon weapon) {
        if(this.weapon == weapon){
            equip(defaultWeapon);
            notifyObservers();
            return true;
        }
        return false;
    }

}
