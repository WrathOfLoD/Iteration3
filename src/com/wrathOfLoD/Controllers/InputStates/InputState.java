package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.MainController;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by icavitt on 4/7/2016.
 */
public abstract class InputState {
    private MainController mainController = MainController.getInstance();
    private boolean isActive = false;
    private Set<Action> activeActionSet = new HashSet<>();

    public void deactivate(){
        for(Action a : activeActionSet){
            a.deactivate();
        }
    }

    public void activate(){
        System.out.println(activeActionSet);
        for(Action a : activeActionSet){

            a.activate();
            System.out.println("activating : " + a.toString());
            System.out.println("is a active?: " + a.isActive());
        }
    }

    protected void setActiveActionSet(Set<Action> actionSet) {
        this.activeActionSet = actionSet;
    }

    public Set<Action> getActiveActionSet() {
        return this.activeActionSet;
    }

    protected void addNewAction(Action a){
        activeActionSet.add(a);
        System.out.println("Added a: " + a + " to active set");
        System.out.println(a);
    }
}
