package com.wrathOfLoD.Models.Commands.SelectableActionCommands;

import com.wrathOfLoD.Views.Selectable;

/**
 * Created by zach on 4/13/16.
 */
public class SelectItemCommand extends SelectCommand {

    public SelectItemCommand(Selectable selectable) {
        super(selectable);
    }

    @Override
    public void execute() {
        this.getSelectable().useSelectedItem();
    }
}
