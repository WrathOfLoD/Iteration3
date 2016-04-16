package com.wrathOfLoD.Models.Commands.SelectableActionCommands;

import com.wrathOfLoD.Views.Selectable;

/**
 * Created by zach on 4/9/16.
 */
public class SelectDownCommand extends SelectCommand {

    public SelectDownCommand(Selectable selectable) {
        super(selectable);
    }

    @Override
    public void execute(){
        this.getSelectable().selectDownItem();
    }
}
