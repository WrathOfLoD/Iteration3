package com.wrathOfLoD.Controllers.InputStates.Action;

import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by icavitt on 4/7/2016.
 */
public abstract class Action implements KeyListener{
    private boolean isActive = false;
    private KeyEvent currKeyCode;
    private ActionCommand myAction;

    public Action(){
    }

    public Action(KeyEvent currKeyCode, ActionCommand myAction){
        this.currKeyCode  = currKeyCode;
        this.myAction = myAction;
    }

    public void keyPressed(KeyEvent keyEvent){
        if(keyEvent == currKeyCode && isActive){
            myAction.execute();
        }
    }

    public void activate(){
        isActive = true;
    }

    public void deactivate(){
        isActive = false;
    }
}
