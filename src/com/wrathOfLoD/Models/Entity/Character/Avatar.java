package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Utility.Position;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */

public class Avatar extends Character implements ActionsHolder {
    private static Avatar avatar = null;
    private Set<Action> actionSet;

    private Avatar() {
        super("Master Chief", new Position(0,0,0,0), new Smasher());
        this.initializeActionSet();
    }

    public static Avatar getInstance(){
        if(avatar == null) {
            avatar = new Avatar();
        }

        return avatar;
    }

    public void avatarInit(String name, Position position, Occupation occupation){
        this.setName(name);
        this.setPosition(position);
        this.setOccupation(occupation);
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
