package com.wrathOfLoD.Dialog;

import java.util.List;

/**
 * Created by matthewdiaz on 4/16/16.
 */
public abstract class DialogContainer {
    private List<String> dialog;
    private int currentDialogLine;

    public DialogContainer(List<String> dialog){
        this.dialog = dialog;
        this.currentDialogLine = 0;
    }

    public String getDialogLine(){
        return dialog.get(currentDialogLine);
    }

    public boolean hasNextLine(){
        return currentDialogLine < dialog.size();
    }

    public void nextLine(){
        currentDialogLine++;
    }

    public abstract void terminalAction();
}
