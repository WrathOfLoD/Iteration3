package com.wrathOfLoD.Controllers.InputStates.Action;

import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by icavitt on 4/7/2016.
 */
public abstract class Action implements KeyListener{
    private boolean isActive = false;
    private boolean isListening = false;
    private int currKeyCode;
    private ActionCommand myAction;

    public Action(int currKeyCode, ActionCommand myAction){
        this.currKeyCode  = currKeyCode;
        this.myAction = myAction;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent){
        if(keyEvent.getKeyCode() == currKeyCode && isListening){
            myAction.execute();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void activate(){
        isListening = true;
    }

    public void deactivate(){
        isListening = false;
    }

    public boolean isActive() { return this.isListening; }


    public int getCurrCode(){
        return currKeyCode;
    }

    protected boolean listenting(){
        return isListening;
    }
}
