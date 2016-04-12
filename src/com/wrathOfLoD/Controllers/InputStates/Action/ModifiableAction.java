package com.wrathOfLoD.Controllers.InputStates.Action;

import com.wrathOfLoD.Models.Commands.ActionCommand;

import java.awt.event.KeyEvent;

/**
 * Created by zach on 4/12/16.
 */
public class ModifiableAction extends Action {
    private boolean isModKeyUpActive;
    private boolean isModKeyDownActive;

    public ModifiableAction(int currKeyCode, ActionCommand myAction){
        super(currKeyCode, myAction);

        this.isModKeyDownActive = false;
        this.isModKeyUpActive = false;
    }

    public void executeUp() {
        System.out.println("Executing up");
    }

    public void executeDown() {
        System.out.println("Executing down");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_SHIFT && this.listenting()) {
            this.isModKeyUpActive = true;
            this.isModKeyDownActive = false;
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_CONTROL && this.listenting()) {
            this.isModKeyDownActive = true;
            this.isModKeyUpActive = false;
        } else {
            if (keyEvent.getKeyCode() == this.getCurrCode() && isModKeyUpActive && this.listenting()) {
                this.executeUp();
            } else if (keyEvent.getKeyCode() == this.getCurrCode() && isModKeyDownActive && this.listenting()) {
                this.executeDown();
            } else {
                super.keyPressed(keyEvent);
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {;
        if (e.getKeyCode() == KeyEvent.VK_SHIFT && this.listenting()) {
            this.isModKeyUpActive = false;
        } else if (e.getKeyCode() == KeyEvent.VK_CONTROL && this.listenting()) {
            this.isModKeyDownActive = false;
        }
    }
}
