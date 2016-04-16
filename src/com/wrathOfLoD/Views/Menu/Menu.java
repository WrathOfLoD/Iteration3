package com.wrathOfLoD.Views.Menu;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Views.Selectable;
import com.wrathOfLoD.Views.StaticView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 4/16/16.
 */
public abstract class Menu extends StaticView implements ActionsHolder, Selectable {
    private int currentIndex = 0;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private Set<Action> actionSet = new HashSet<>();

    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }


    /**
     * desc: Increment to previous row
     */
    public void safeDecrementUp() {
        int prevIndex = this.currentIndex;
        this.currentIndex--;

        if (this.currentIndex < 0)
            this.currentIndex = prevIndex;
    }

    /**
     * desc: Increment to next row
     */
    public void safeIncrementDown() {
        int prevIndex = this.currentIndex;
        this.currentIndex++;

        if (this.currentIndex >= this.getMenuItems().size())
            this.currentIndex = prevIndex;
    }

    public void selectUpItem() {
        this.safeDecrementUp();
    }

    public void selectDownItem() {
        this.safeIncrementDown();
    }

    /**
     * desc: Return the currently selected item
     */
    public Object useSelectedItem() {
        System.out.println(this.getMenuItems().get(currentIndex));

        this.getMenuItems().get(currentIndex).execute();

        return this.getMenuItems().get(currentIndex);
    }

    @Override
    public Set<Action> getActionSet() {
        return this.actionSet;
    }

    @Override
    public void initializeActionSet() {
        this.addToActionSet(ActionVendor.createSelectUpAction(this));
        this.addToActionSet(ActionVendor.createSelectDownAction(this));
        this.addToActionSet(ActionVendor.createSelectItemAction(this));
    }

    @Override
    public void setActionSet(Set<Action> actionSet) {

    }

    @Override
    public void addToActionSet(Action action) {
        this.actionSet.add(action);
    }

    @Override
    public void selectNextItem() {

    }

    @Override
    public void selectPrevItem() {

    }
}
