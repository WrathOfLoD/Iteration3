package com.wrathOfLoD.Models;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;

import java.util.List;
import java.util.Set;

/**
 * Created by zach on 4/8/16.
 */
public interface ActionsHolder {
    Set<Action> getActionSet();
    void initializeActionSet();
    void setActionSet(Set<Action> actionSet);
    void addToActionSet(Action action);
}
