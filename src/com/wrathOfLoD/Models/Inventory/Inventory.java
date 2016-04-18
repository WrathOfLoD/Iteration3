package com.wrathOfLoD.Models.Inventory;


import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Models.Items.TakeableItem;
import com.wrathOfLoD.Observers.ModelObservers.EquipmentObserver;
import com.wrathOfLoD.Observers.Observable;
import com.wrathOfLoD.Observers.Observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */
public class Inventory implements ActionsHolder, Observable, EquipmentObserver {


    private List<TakeableItem> itemList;
    private Set<Action> actionSet = new HashSet<>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public void equipmentAlertResponse(TakeableItem item) {
        if (item!=null) {
            this.addItem(item);
        }
        System.out.println("Responding to equipmet alert in inventory for " + item);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
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

    public Inventory() {
        this.itemList = new ArrayList();
        this.initializeActionSet();
    }


    public void addItem(TakeableItem item) {
        itemList.add(item);
        notifyObservers();
    }

    public boolean hasItem(TakeableItem item){ return itemList.contains(item); }

    public void removeItem(TakeableItem item) {
        if(hasItem(item))
            itemList.remove(item);
            notifyObservers();
    }

    public List<TakeableItem> getItemList(){
        return this.itemList;
    }


    @Override
    public Set<Action> getActionSet() {
        return this.actionSet;
    }

    @Override
    public void initializeActionSet() {
        this.addToActionSet(ActionVendor.createRevertToAvatarStateAction());
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
