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

    public Action(){
    }

    public Action(int currKeyCode, ActionCommand myAction){
        this.currKeyCode  = currKeyCode;
        this.myAction = myAction;
    }

    public void keyPressed(KeyEvent keyEvent){
        System.out.println("Key typed");
        System.out.println(keyEvent.getKeyCode());
        System.out.println(getCurrCode());
        System.out.println(listenting());
        if(keyEvent.getKeyCode() == currKeyCode && isListening){
            myAction.execute();
        }
    }

    public void activate(){
        isListening = true;
    }

    public void deactivate(){
        isListening = false;
    }

    public boolean isActive() { return this.isListening; }


    protected int getCurrCode(){
        return currKeyCode;
    }

    protected boolean listenting(){
        return isListening;
    }
}
