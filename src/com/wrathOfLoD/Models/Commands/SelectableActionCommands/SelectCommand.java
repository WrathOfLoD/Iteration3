package com.wrathOfLoD.Models.Commands.SelectableActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Views.Selectable;

/**
 * Created by zach on 4/13/16.
 */
public abstract class SelectCommand extends ActionCommand {
    private Selectable selectable;
    private Entity entity;

    public SelectCommand(Selectable inventoryView) {
        this.selectable = inventoryView;
    }

    public Selectable getSelectable() { return this.selectable; }

}
