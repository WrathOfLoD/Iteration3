package com.wrathOfLoD.Models.Inventory;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.Greaves;
import com.wrathOfLoD.Models.Items.EquippableItems.Helm;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Observers.ModelObservers.EquipmentObservable;
import com.wrathOfLoD.Observers.ModelObservers.EquipmentObserver;
import com.wrathOfLoD.Observers.Observable;
import com.wrathOfLoD.Observers.Observer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */
public class Equipment implements Observable, ActionsHolder, EquipmentObservable {
    private final Weapon defaultWeapon;
    private Set<Action> actionSet = new HashSet<>();
    private Armor armor;
    private Weapon weapon;
    private Greaves greaves;
    private Helm helm;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private ArrayList<EquipmentObserver> equipmentObservers = new ArrayList<>();

    public Equipment(Weapon defaultWeapon){
        this.defaultWeapon = defaultWeapon;
        setWeapon(this.defaultWeapon);
    }

    @Override
    public void alertEquipmentChange(TakeableItem item) {
        for (EquipmentObserver eo: equipmentObservers) {
            eo.equipmentAlertResponse(item);
        }
    }

    @Override
    public void registerEquipmentObserver(EquipmentObserver eo) {
        System.out.println("Registering equpment observsder");
        equipmentObservers.add(eo);
    }

    @Override
    public void removeEquipmentObserver(EquipmentObserver eo) {
        equipmentObservers.remove(eo);
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


    public TakeableItem equip(Armor armor){
        TakeableItem ri = null;
        if (this.armor != null) ri = this.armor;
        alertEquipmentChange(getArmor());
        this.armor = armor;
        notifyObservers();
        return ri;


    }

    public TakeableItem equip(Greaves greaves) {
        TakeableItem ri = null;
        if (this.greaves != null) ri = this.greaves;
        alertEquipmentChange(getGreaves());
        this.greaves = greaves;
        notifyObservers();
        return ri;
    }

    public TakeableItem equip(Helm helm){
        TakeableItem ri = null;
        if (this.helm != null) ri = this.helm;
        alertEquipmentChange(getHelm());
        this.helm = helm;
        notifyObservers();
        return ri;
    }

    public TakeableItem equip(Weapon weapon) {
        TakeableItem ri = null;
        if (this.weapon != null) ri = this.weapon;
        alertEquipmentChange(getWeapon());
        this.weapon = weapon;
        notifyObservers();
        // TODO: 4/9/16 do the below for the view
        // alertWeaponEquipped(weapon);
        return ri;

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
            this.greaves = null;
            notifyObservers();
            return true;
        }
        return false;
    }

    public boolean unequip(Helm helm){
        if(this.helm == helm){
            this.helm = null;
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

    @Override
    public Set<Action> getActionSet() {
        return this.actionSet;
    }

    @Override
    public void initializeActionSet() {

    }

    @Override
    public void setActionSet(Set<Action> actionSet) {
        this.actionSet = actionSet;
    }

    @Override
    public void addToActionSet(Action action) {
        this.actionSet.add(action);
    }
}
