package com.wrathOfLoD.Models.Commands.EntityActionCommands;

import com.wrathOfLoD.Models.Commands.ActionCommand;
import com.wrathOfLoD.Models.Entity.Entity;

/**
 * Created by matthewdiaz on 4/8/16.
 */
public class DieCommand  extends ActionCommand {
    private Entity e;

    public DieCommand(Entity e){
        this.e = e;
    }
    @Override
    public void execute() {

    }
}
