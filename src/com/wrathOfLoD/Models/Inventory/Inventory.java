package com.wrathOfLoD.Models.Inventory;


import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Models.Items.TakeableItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */
public class Inventory implements ActionsHolder {
    private List<TakeableItem> itemList;
    private Set<Action> actionSet;

    public Inventory() {
        this.itemList = new ArrayList();
        this.initializeActionSet();
    }


    public void addItem(TakeableItem item) {
        itemList.add(item);
    }

    public boolean removeItem(TakeableItem item) {
        return itemList.remove(item);
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
        this.actionSet = new HashSet<>();
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
