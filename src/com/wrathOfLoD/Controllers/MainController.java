package com.wrathOfLoD.Controllers;

import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Models.Entity.Character.Avatar;

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
    private InputState previousState;   // May be needed


    
    // TODO: MainController will need a reference to the main view or something, so that it can
    // TODO: add key listeners to it!
    //      addActionKeyListeners() {
    //          activeState.getActiveActionSet().stream()
    //                  .forEach(s -> f.addKeyListener(s));

    private MainController() {
    }

    public static MainController getInstance(){
        return instance;
    }
    
    public void setActiveState(InputState newState) {
        this.previousState = this.activeState;
        this.activeState = newState;

        if (this.previousState != null)
            this.previousState.deactivate();

//        this.removeActionKeyListeners();
        this.activeState.activate();
//        this.addActionKeyListeners();
    }

    // TODO: 4/8/16 IMPLEMENT once we have the main game window/frame! 
//    public void addActionKeyListeners() {
//          activeState.getActiveActionSet().stream()
//                  .forEach(s -> frame.addKeyListener(s));
//    }
//    // TODO: 4/8/16 IMPLEMENT once we have the main game window/frame!
//    public void removeActionKeyListeners() {
//          activeState.getActiveActionSet().stream()
//                  .forEach(s -> frame.removeKeyListener(s));
//    }

}
