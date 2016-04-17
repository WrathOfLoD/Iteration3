package com.wrathOfLoD.Models.Dialog;

import java.util.List;

/**
 * Created by matthewdiaz on 4/16/16.
 */
public class SpeechDialogContainer extends  DialogContainer {
    public SpeechDialogContainer(List<String> dialog) {
        super(dialog);
    }

    public void terminalAction(){
        //just close the dialogView
    }
}
