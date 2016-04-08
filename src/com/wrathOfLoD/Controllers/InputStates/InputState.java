package com.wrathOfLoD.Controllers.InputStates;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.MainController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by icavitt on 4/7/2016.
 */
public abstract class InputState {
    private MainController mainController = MainController.getInstance();
    private boolean isActive = false;
    private ArrayList<Action> activeActionSet;

    public void deactivate(){
        for(Action a : activeActionSet){
            a.deactivate();
        }
    }

    public void activate(){
        for(Action a : activeActionSet){
            a.activate();
        }
    }

    protected void addNewAction(Action a){
        activeActionSet.add(a);
    }
}
