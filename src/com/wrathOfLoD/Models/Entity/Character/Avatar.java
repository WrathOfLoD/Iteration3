package com.wrathOfLoD.Models.Entity.Character;

import com.wrathOfLoD.Controllers.InputStates.Action.Action;
import com.wrathOfLoD.Controllers.InputStates.ActionVendor;
import com.wrathOfLoD.Models.ActionsHolder;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.SmasherWeapon;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Occupation.Smasher;
import com.wrathOfLoD.Models.Stats.StatsModifiable;
import com.wrathOfLoD.Models.Target.AvatarTargetManager;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.EntityVisitor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 4/7/16.
 */

public class Avatar extends Character implements ActionsHolder {
    private static Avatar avatar = null;
    private Set<Action> actionSet;

    private Avatar() {
        super();
        setTargetManager(new AvatarTargetManager());
    }

    public static Avatar getInstance(){
        if (avatar == null) {

            avatar = new Avatar();
            avatar.initializeActionSet();
        }

        return avatar;
    }

    public void configureAvatar(String name, Position position, Occupation occupation){
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
        // Add default Avatar Movement actions
        this.addToActionSet(ActionVendor.createMoveNorthAction());
        this.addToActionSet(ActionVendor.createMoveNorthEastAction());
        this.addToActionSet(ActionVendor.createMoveNorthWestAction());
        this.addToActionSet(ActionVendor.createMoveSouthAction());
        this.addToActionSet(ActionVendor.createMoveSouthEastAction());
        this.addToActionSet(ActionVendor.createMoveSouthWestAction());


    }

    @Override
    public void setActionSet(Set<Action> actionSet) {
        this.actionSet = actionSet;
    }

    @Override
    public void addToActionSet(Action action) {
        this.actionSet.add(action);
    }

    public void accept(EntityVisitor ev){
        ev.visitAvatar(this);
    }
}
