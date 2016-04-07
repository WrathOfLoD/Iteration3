package com.wrathOfLoD.Controllers;

import com.wrathOfLoD.Controllers.InputStates.InputState;
import com.wrathOfLoD.Models.Entity.Character.Avatar;

/**
 * Created by icavitt on 4/7/2016.
 */
public class MainController {
    private static MainController instance = new MainController();
    private Avatar avatar = Avatar.getInstance();
    private InputState avatarState;
    private InputState MenuState;
    private InputState activeState;

    private MainController(){
    }

    public static MainController getInstance(){
        return instance;
    }

}
