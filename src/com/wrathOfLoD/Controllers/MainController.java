package com.wrathOfLoD.Controllers;

import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Views.ViewEngine;
import com.wrathOfLoD.Views.ViewManager.ViewManager;

import javax.swing.*;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MainController {
    private static MainController instance = new MainController();
    private Avatar avatar = Avatar.getInstance();
    private InputState avatarState;
    private InputState MenuState;
    private InputState activeState;
    private InputState previousState;

    private MainController() {
    }

    public static MainController getInstance(){
        return instance;
    }

    /**
     * @desc Set the active InputState for the controller, i.e. AvatarState
     */
    public void setActiveState(InputState newState) {
        this.previousState = this.activeState;
        this.activeState = newState;

        if (this.previousState != null) {
            this.previousState.deactivate();
            this.removeActionKeyListeners();
        }

        System.out.println("Activting");
        this.activeState.activate();

        this.addActionKeyListeners();
    }

    /**
     * @desc Add the activeState's actionSet key listeners to the ViewEngine
     */
    public void addActionKeyListeners() {
          activeState.getActiveActionSet().stream()
                  .forEach(action -> ViewEngine.getInstance().addKeyListener(action));
    }

    /**
     * @desc Remove the activeState's actionSet key listeners from the ViewEngine
     */
    public void removeActionKeyListeners() {
          activeState.getActiveActionSet().stream()
                  .forEach(action -> ViewEngine.getInstance().removeKeyListener(action));
    }

}
